package ru.zgz.star.backend.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import ru.zgz.star.backend.models.Role;
import ru.zgz.star.backend.models.Tutor;
import ru.zgz.star.backend.util.DbUtil;

/** DAO for role table. */
public class RoleDao {
  private final Connection connection;

  /** Instantiates a new Role dao. */
  public RoleDao() {
    this.connection = DbUtil.getConnection();
  }

  /**
   * Instantiates a new Role dao.
   *
   * @param connection the connection
   */
  public RoleDao(Connection connection) {
    this.connection = connection;
  }

  /**
   * Create new Role.
   *
   * @param role the role
   */
  public void add(Role role) {
    try {
      PreparedStatement query =
          connection.prepareStatement(
              "insert into role(role_name, role_description) values (?,?);");
      query.setString(1, role.getRoleName());
      query.setString(2, role.getRoleDescription());
      query.executeUpdate();
      query.close();
      connection.commit();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  /**
   * Gets all roles.
   *
   * @return list of roles
   */
  public List<Role> getAll() {
    List<Role> roles = new ArrayList<>();
    try {
      Statement st = connection.createStatement();
      ResultSet rs = st.executeQuery("select * from role");
      while (rs.next()) {
        roles.add(
            new Role()
                .setId(UUID.fromString(rs.getString("id")))
                .setRoleName(rs.getString("role_name"))
                .setRoleDescription(rs.getString("role_description")));
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return roles;
  }

  /**
   * Gets exact role by id.
   *
   * @param id id of role
   * @return exact role
   */
  public Role getById(String id) {
    try {
      PreparedStatement query = connection.prepareStatement("select * from role where id=?");
      query.setObject(1, UUID.fromString(id));
      ResultSet rs = query.executeQuery();
      return buildRole(rs);
    } catch (SQLException e) {
      e.printStackTrace();
      return null;
    }
  }

  /**
   * Delete exact role by id.
   *
   * @param id id of role
   */
  public void deleteById(UUID id) {
    try {
      PreparedStatement st = connection.prepareStatement("delete from role where id=?");
      st.setObject(1, id);
      connection.commit();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  /** Delete all roles. */
  @SuppressWarnings("SqlWithoutWhere")
  public void deleteAll() {
    try {
      Statement st = connection.createStatement();
      st.executeUpdate("delete from role");
      connection.commit();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  private Role buildRole(ResultSet rs) throws SQLException {
    if (rs.next()) {
      return new Role()
          .setId(UUID.fromString(rs.getString("id")))
          .setRoleName(rs.getString("role_name"))
          .setRoleDescription(rs.getString("role_description"));
    } else {
      return null;
    }
  }
}
