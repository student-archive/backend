package ru.zgz.star.backend.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import ru.zgz.star.backend.models.AttachmentType;
import ru.zgz.star.backend.models.Group;
import ru.zgz.star.backend.util.DbUtil;

/** DAO for Group table. */
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
   * Create new group.
   *
   * @param group the group
   */
  public void add(Group group) {
    try {
      PreparedStatement query =
          connection.prepareStatement(
              "insert into group(group_name) values (?);");
      query.setString(1, group.getGroupName());
      query.executeUpdate();
      query.close();
      connection.commit();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  /**
   * Gets all group.
   *
   * @return list of group
   */
  public List<Group> getAll() {
    List<Group> groups = new ArrayList<>();
    try {
      Statement st = connection.createStatement();
      ResultSet rs = st.executeQuery("select * from \"group\"");
      while (rs.next()) {
        groups.add(
            new Group()
                .setId(UUID.fromString(rs.getString("id")))
                .setGroupName(rs.getString("groupName")));
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
      return buildGroup(rs);
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
      connection.commit();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  /** Delete all accounts. */
  @SuppressWarnings("SqlWithoutWhere")
  public void deleteAll() {
    try {
      Statement st = connection.createStatement();
      st.executeUpdate("delete from \"group\"");
      connection.commit();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  private Group buildGroup(ResultSet rs) throws SQLException {
    if (rs.next()) {
      return new Group()
          .setId(UUID.fromString(rs.getString("id")))
          .setGroupName(rs.getString("groupName"));
    } else {
      return null;
    }
  }
}
