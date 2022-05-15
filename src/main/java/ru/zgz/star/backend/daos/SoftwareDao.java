package ru.zgz.star.backend.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import ru.zgz.star.backend.models.Account;
import ru.zgz.star.backend.models.Software;
import ru.zgz.star.backend.util.DbUtil;

/** DAO for software table. */
public class SoftwareDao {
  private final Connection connection;

  /** Instantiates a new Software dao. */
  public SoftwareDao() {
    this.connection = DbUtil.getConnection();
  }

  /**
   * Instantiates a new Software dao.
   *
   * @param connection the connection
   */
  public SoftwareDao(Connection connection) {
    this.connection = connection;
  }

  /**
   * Updates software.
   *
   * @param software updated software
   * @return updated software
   */
  public List<Software> update(Software software) {
    List<Software> softwares = new ArrayList<>();
    try {
      PreparedStatement query =
          connection.prepareStatement(
              "update software set description=?, link=?, subject_id=? where id=?",
              Statement.RETURN_GENERATED_KEYS);
      query.setObject(1, software.getDescription());
      query.setObject(2, software.getLink());
      query.setObject(3, software.getSubject());
      query.executeUpdate();

      ResultSet rs = query.getGeneratedKeys();
      while (rs.next()) {
        softwares.add(buildSoftware(rs));
      }

      query.close();
      connection.commit();

      return softwares;

    } catch (SQLException e) {
      e.printStackTrace();
      return null;
    }
  }


  /**
   * Create new Software.
   *
   * @param software the software
   */
  public Software add(Software software) {
    try {
      Software newSoftware = new Software();
      PreparedStatement query =
          connection.prepareStatement(
              "insert into software(link, description, subject_id) values (?,?,?);", Statement.RETURN_GENERATED_KEYS);
      query.setString(1, software.getLink());
      query.setString(2, software.getDescription());
      query.setObject(3, software.getSubject());
      query.executeUpdate();

      ResultSet rs = query.getGeneratedKeys();
      if (rs.next()) {
        newSoftware = buildSoftware(rs);
      }

      query.close();
      connection.commit();
      return newSoftware;
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return null;
  }

  /**
   * Gets all software.
   *
   * @return list of software
   */
  public List<Software> getAll() {
    List<Software> softwares = new ArrayList<>();
    try {
      Statement st = connection.createStatement();
      ResultSet rs = st.executeQuery("select * from software");
      while (rs.next()) {
        softwares.add(buildSoftware(rs));
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return softwares;
  }

  /**
   * Gets exact software by id.
   *
   * @param id id of software
   * @return exact software
   */
  public Software getById(String id) {
    try {
      PreparedStatement query = connection.prepareStatement("select * from software where id=?");
      query.setObject(1, UUID.fromString(id));
      ResultSet rs = query.executeQuery();
      if (rs.next()) {
        return buildSoftware(rs);
      } else {
        return null;
      }
    } catch (SQLException e) {
      e.printStackTrace();
      return null;
    }
  }

  /**
   * Delete exact software by id.
   *
   * @param id id of software
   */
  public void deleteById(UUID id) {
    try {
      PreparedStatement st = connection.prepareStatement("delete from software where id=?");
      st.setObject(1, id);
      connection.commit();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  /** Delete all software. */
  @SuppressWarnings("SqlWithoutWhere")
  public void deleteAll() {
    try {
      Statement st = connection.createStatement();
      st.executeUpdate("delete from software");
      st.close();
      connection.commit();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  private Software buildSoftware(ResultSet rs) throws SQLException {
    Software software =
       new Software()
          .setId(UUID.fromString(rs.getString("id")))
          .setLink(rs.getString("link"))
          .setDescription(rs.getString("Description"))
          .setSubject((UUID) rs.getObject("subject"));
    return software;
  }
}
