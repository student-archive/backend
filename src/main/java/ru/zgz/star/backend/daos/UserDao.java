package ru.zgz.star.backend.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import ru.zgz.star.backend.models.User;
import ru.zgz.star.backend.util.DbUtil;

/** DAO for user table. */
public class UserDao {
  private final Connection connection;

  /** Instantiates a new User dao. */
  public UserDao() {
    this.connection = DbUtil.getConnection();
  }

  /**
   * Instantiates a new User dao.
   *
   * @param connection the connection
   */
  public UserDao(Connection connection) {
    this.connection = connection;
  }

  /**
   * Create new User.
   *
   * @param user the user
   */
  public void add(User user) {
    try {
      PreparedStatement query =
          connection.prepareStatement(
              "insert into \"user\" (first_name, last_name, avatar_link, role_id, account_id,"
                  + " group_id, sex_id) values (?, ?, ?, ?, ?, ?, ?);");
      query.setString(1, user.getFirstName());
      query.setString(2, user.getLastName());
      query.setString(3, user.getAvatarLink());
      query.setObject(4, user.getRole());
      query.setObject(5, user.getAccount());
      query.setObject(6, user.getGroup());
      query.setObject(7, user.getSex());
      query.executeUpdate();
      query.close();
      connection.commit();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  /**
   * Gets all users.
   *
   * @return list of users
   */
  public List<User> getAll() {
    List<User> users = new ArrayList<>();
    try {
      Statement st = connection.createStatement();
      ResultSet rs = st.executeQuery("select * from \"user\"");
      while (rs.next()) {
        users.add(
            new User()
                .setId(UUID.fromString(rs.getString("id")))
                .setFirstName(rs.getString("first_name"))
                .setLastName(rs.getString("last_name"))
                .setAvatarLink(rs.getString("avatar_link"))
                .setRole((UUID) rs.getObject("role_id"))
                .setAccount((UUID) rs.getObject("account_id"))
                .setSex((UUID) rs.getObject("sex_id")));
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return users;
  }

  /**
   * Gets exact user by id.
   *
   * @param id id of user
   * @return exact user
   */
  public User getById(String id) {
    try {
      PreparedStatement query = connection.prepareStatement("select * from \"user\" where id=?");
      query.setObject(1, UUID.fromString(id));
      ResultSet rs = query.executeQuery();
      return buildUser(rs);
    } catch (SQLException e) {
      e.printStackTrace();
      return null;
    }
  }

  /**
   * Delete exact user by id.
   *
   * @param id id of user
   */
  public void deleteById(UUID id) {
    try {
      PreparedStatement st = connection.prepareStatement("delete from \"user\" where id=?");
      st.setObject(1, id);
      connection.commit();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  /** Delete all users. */
  @SuppressWarnings("SqlWithoutWhere")
  public void deleteAll() {
    try {
      Statement st = connection.createStatement();
      st.executeUpdate("delete from \"user\"");
      connection.commit();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  private User buildUser(ResultSet rs) throws SQLException {
    if (rs.next()) {
      return new User()
          .setId(UUID.fromString(rs.getString("id")))
          .setFirstName(rs.getString("priority_name"))
          .setLastName(rs.getString("last_name"))
          .setAvatarLink(rs.getString("avatar_link"))
          .setRole((UUID) rs.getObject("role_id"))
          .setAccount((UUID) rs.getObject("account_id"))
          .setSex((UUID) rs.getObject("sex_id"));
    } else {
      return null;
    }
  }
}
