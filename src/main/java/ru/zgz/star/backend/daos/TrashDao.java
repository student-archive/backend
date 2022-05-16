package ru.zgz.star.backend.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import ru.zgz.star.backend.models.Group;
import ru.zgz.star.backend.models.Trash;
import ru.zgz.star.backend.util.DbUtil;

/** DAO for trash table. */
public class TrashDao {
  private final Connection connection;

  /** Instantiates a new Group dao. */
  public TrashDao() {
    this.connection = DbUtil.getConnection();
  }

  /**
   * Instantiates a new Trash dao.
   *
   * @param connection the connection
   */
  public TrashDao(Connection connection) {
    this.connection = connection;
  }

  /**
   * Checks if trash exists.
   *
   * @param id id of trash
   * @return true if trash exists
   */
  public Boolean findById(UUID id) {
    try {
      PreparedStatement query =
          connection.prepareStatement("select count(*) from trash where id=?");
      query.setObject(1, id);
      ResultSet rs = query.executeQuery();
      if (rs.next()) {
        return rs.getInt(1) > 0;
      }
    } catch (SQLException e) {
      e.printStackTrace();
      return false;
    }
    return false;
  }

  /**
   * Updates trash.
   *
   * @param trash updated trash
   * @return updated trash
   */
  public List<Trash> update(Trash trash) {
    List<Trash> trashes = new ArrayList<>();
    try {
      PreparedStatement query =
          connection.prepareStatement(
              "update trash set deleted_id=?, deleted_date=?, group_id=?  where id=?",
              Statement.RETURN_GENERATED_KEYS);
      query.setObject(1, trash.getDeletedId());
      query.setObject(2, trash.getDeletingDate());
      query.setObject(3, trash.getGroup());
      query.setObject(4, trash.getId());
      query.executeUpdate();

      ResultSet rs = query.getGeneratedKeys();
      while (rs.next()) {
        trashes.add(buildTrash(rs));
      }

      query.close();
      connection.commit();

      return trashes;

    } catch (SQLException e) {
      e.printStackTrace();
      return null;
    }
  }

  /**
   * Create new trash.
   *
   * @param trash the trash
   * @return created trash
   */
  public Trash add(Trash trash) {
    try {
      Trash newTrash = new Trash();
      PreparedStatement query =
          connection.prepareStatement(
              "insert into trash (deleted_id, deleted_date, group_id) values (?, ?, ?);",
              Statement.RETURN_GENERATED_KEYS);
      query.setObject(1, trash.getDeletedId());
      query.setObject(2, trash.getDeletingDate());
      query.setObject(3, trash.getGroup());
      query.executeUpdate();

      ResultSet rs = query.getGeneratedKeys();
      if (rs.next()) {
        newTrash = buildTrash(rs);
      }

      query.close();
      connection.commit();
      return newTrash;
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return null;
  }

  /**
   * Gets all trash.
   *
   * @return list of trashes
   */
  public List<Trash> getAll() {
    List<Trash> trashes = new ArrayList<>();
    try {
      Statement st = connection.createStatement();
      ResultSet rs = st.executeQuery("select * from trash");
      while (rs.next()) {
        trashes.add(buildTrash(rs));
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return trashes;
  }

  /**
   * Gets exact trash by id.
   *
   * @param id id of trash
   * @return exact trash
   */
  public Trash getById(String id) {
    try {
      PreparedStatement query = connection.prepareStatement("select * from trash where id=?");
      query.setObject(1, UUID.fromString(id));
      ResultSet rs = query.executeQuery();
      if (rs.next()) {
        return buildTrash(rs);
      } else {
        return null;
      }
    } catch (SQLException e) {
      e.printStackTrace();
      return null;
    }
  }

  /**
   * Delete exact trash by id.
   *
   * @param id id of trash
   */
  public void deleteById(UUID id) {
    try {
      PreparedStatement st = connection.prepareStatement("delete from trash where id=?");
      st.setObject(1, id);
      connection.commit();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  /** Delete all trashes. */
  @SuppressWarnings("SqlWithoutWhere")
  public void deleteAll() {
    try {
      Statement st = connection.createStatement();
      st.executeUpdate("delete from trash");
      st.close();
      connection.commit();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  private Trash buildTrash(ResultSet rs) throws SQLException {
    return new Trash()
        .setId(UUID.fromString(rs.getString("id")))
        .setDeletedId((UUID) rs.getObject("deleted_id"))
        .setDeletingDate(rs.getInt("deleted_date"))
        .setGroup((UUID) rs.getObject("group_id"));
  }
}
