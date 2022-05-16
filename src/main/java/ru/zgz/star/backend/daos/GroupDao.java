package ru.zgz.star.backend.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import ru.zgz.star.backend.exceptions.ModelBuildException;
import ru.zgz.star.backend.models.Group;
import ru.zgz.star.backend.util.DbUtil;

/** DAO for group table. */
public class GroupDao {
  private final Connection connection;

  /** Instantiates a new Group dao. */
  public GroupDao() {
    this.connection = DbUtil.getConnection();
  }

  /**
   * Instantiates a new Group dao.
   *
   * @param connection the connection
   */
  public GroupDao(Connection connection) {
    this.connection = connection;
  }

  /**
   * Checks if group exists.
   *
   * @param id id of group
   * @return true if group exists
   */
  public Boolean findById(UUID id) {
    try {
      PreparedStatement query =
          connection.prepareStatement("select count(*) from \"group\" where id=?");
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
   * Updates group.
   *
   * @param group updated group
   * @return updated group
   */
  public List<Group> update(Group group) {
    List<Group> groups = new ArrayList<>();
    try {
      PreparedStatement query =
          connection.prepareStatement(
              "update \"group\" set group_name=?, university_id=?, speciality_id=?  where id=?",
              Statement.RETURN_GENERATED_KEYS);
      query.setObject(1, group.getGroupName());
      query.setObject(2, group.getUniversity());
      query.setObject(3, group.getSpeciality());
      query.setObject(4, group.getId());
      query.executeUpdate();

      ResultSet rs = query.getGeneratedKeys();
      while (rs.next()) {
        groups.add(buildGroup(rs));
      }

      query.close();
      connection.commit();

      return groups;

    } catch (SQLException e) {
      e.printStackTrace();
      return null;
    }
  }

  /**
   * Create new group.
   *
   * @param group the group
   * @return created group
   */
  public Group add(Group group) {
    try {
      Group newGroup = new Group();
      PreparedStatement query =
          connection.prepareStatement(
              "insert into \"group\"(group_name, university_id, speciality_id) values (?, ?, ?);",
              Statement.RETURN_GENERATED_KEYS);
      query.setString(1, group.getGroupName());
      query.setObject(2, group.getUniversity());
      query.setObject(3, group.getSpeciality());
      query.executeUpdate();

      ResultSet rs = query.getGeneratedKeys();
      if (rs.next()) {
        newGroup = buildGroup(rs);
      } else {
        throw new ModelBuildException("Can't create account");
      }

      query.close();
      connection.commit();
      return newGroup;
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return null;
  }

  /**
   * Gets all group.
   *
   * @return list of groups
   */
  public List<Group> getAll() {
    List<Group> groups = new ArrayList<>();
    try {
      Statement st = connection.createStatement();
      ResultSet rs = st.executeQuery("select * from \"group\"");
      while (rs.next()) {
        groups.add(buildGroup(rs));
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return groups;
  }

  /**
   * Gets exact group by id.
   *
   * @param id id of group
   * @return exact group
   */
  public Group getById(String id) {
    try {
      PreparedStatement query = connection.prepareStatement("select * from \"group\" where id=?");
      query.setObject(1, UUID.fromString(id));
      ResultSet rs = query.executeQuery();
      if (rs.next()) {
        return buildGroup(rs);
      } else {
        throw new ModelBuildException("Can't create account");
      }
    } catch (SQLException e) {
      e.printStackTrace();
      return null;
    }
  }

  /**
   * Delete exact group by id.
   *
   * @param id id of group
   */
  public void deleteById(UUID id) {
    try {
      PreparedStatement st = connection.prepareStatement("delete from \"group\" where id=?");
      st.setObject(1, id);
      st.executeUpdate();
      st.close();
      connection.commit();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  /** Delete all groups. */
  @SuppressWarnings("SqlWithoutWhere")
  public void deleteAll() {
    try {
      Statement st = connection.createStatement();
      st.executeUpdate("delete from \"group\"");
      st.close();
      connection.commit();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  private Group buildGroup(ResultSet rs) throws SQLException {
    return new Group()
        .setId(UUID.fromString(rs.getString("id")))
        .setGroupName(rs.getString("group_name"))
        .setUniversity((UUID) rs.getObject("university_id"))
        .setSpeciality((UUID) rs.getObject("speciality_id"));
  }
}
