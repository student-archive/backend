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
   * Checks if user exists.
   *
   * @param id id of user
   * @return true if user exists
   */
  public Boolean findById(UUID id) {
    try {
      PreparedStatement query =
          connection.prepareStatement("select count(*) from \"user\" where id=?");
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
   * Updates user.
   *
   * @param user updated user
   * @return updated user
   */
  public List<User> update(User user) {
    List<User> users = new ArrayList<>();
    try {
      PreparedStatement query =
          connection.prepareStatement(
              "update \"user\" set first_name=?, last_name=?, account_id=?, group_id=?, role_id=?,"
                  + " sex_id=?, avatar_link=? where id=?",
              Statement.RETURN_GENERATED_KEYS);
      query.setObject(1, user.getFirstName());
      query.setObject(2, user.getLastName());
      query.setObject(3, user.getAccount());
      query.setObject(4, user.getGroup());
      query.setObject(5, user.getRole());
      query.setShort(6, user.getSex());
      query.setObject(7, user.getAvatarLink());
      query.setObject(8, user.getId());
      query.executeUpdate();

      ResultSet rs = query.getGeneratedKeys();
      while (rs.next()) {
        users.add(buildUser(rs));
      }

      query.close();
      connection.commit();

      return users;

    } catch (SQLException e) {
      e.printStackTrace();
      return null;
    }
  }

  /**
   * Create new User.
   *
   * @param user the user
   * @return added user
   */
  public User add(User user) {
    try {
      User newUser = new User();
      PreparedStatement query =
          connection.prepareStatement(
              "insert into \"user\" (first_name, last_name, avatar_link, role_id, account_id,"
                  + " group_id, sex_id) values (?, ?, ?, ?, ?, ?, ?);",
              Statement.RETURN_GENERATED_KEYS);
      query.setString(1, user.getFirstName());
      query.setString(2, user.getLastName());
      query.setString(3, user.getAvatarLink());
      query.setObject(4, user.getRole());
      query.setObject(5, user.getAccount());
      query.setObject(6, user.getGroup());
      query.setShort(7, user.getSex());
      query.executeUpdate();

      ResultSet rs = query.getGeneratedKeys();
      if (rs.next()) {
        newUser = buildUser(rs);
      }

      query.close();
      connection.commit();

      return newUser;

    } catch (SQLException e) {
      e.printStackTrace();
    }
    return null;
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
                .setSex(rs.getShort("sex_id")));
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
      if (rs.next()) {
        return buildUser(rs);
      }
    } catch (SQLException e) {
      e.printStackTrace();
      return null;
    }
    return null;
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
    return new User()
        .setId(UUID.fromString(rs.getString("id")))
        .setFirstName(rs.getString("priority_name"))
        .setLastName(rs.getString("last_name"))
        .setAvatarLink(rs.getString("avatar_link"))
        .setRole((UUID) rs.getObject("role_id"))
        .setAccount((UUID) rs.getObject("account_id"))
        .setSex(rs.getShort("sex_id"));
  }
}
