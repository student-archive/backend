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
import ru.zgz.star.backend.models.Role;
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
   * Updates Role.
   *
   * @param role updated account
   * @return updated account
   */
  public List<Role> update(Role role) {
    List<Role> roles = new ArrayList<>();
    try {
      PreparedStatement query =
          connection.prepareStatement(
              "update role set role_name=?, role_description=? where id=?",
              Statement.RETURN_GENERATED_KEYS);
      query.setObject(1, role.getRoleName());
      query.setObject(2, role.getRoleDescription());

      query.executeUpdate();

      ResultSet rs = query.getGeneratedKeys();
      while (rs.next()) {
        roles.add(buildRole(rs));
      }

      query.close();
      connection.commit();

      return roles;

    } catch (SQLException e) {
      e.printStackTrace();
      return null;
    }
  }

  /**
   * Create new Role.
   *
   * @param role the role
   */
  public Role add(Role role) {
    try {
      Role newRole = new Role();
      PreparedStatement query =
          connection.prepareStatement(
              "insert into role(role_name, role_description) values (?,?);",
              Statement.RETURN_GENERATED_KEYS);
      query.setString(1, role.getRoleName());
      query.setString(2, role.getRoleDescription());
      query.executeUpdate();
      ResultSet rs = query.getGeneratedKeys();
      if (rs.next()) {
        newRole = buildRole(rs);
      } else {
        throw new ModelBuildException("Can't create role");
      }

      query.close();
      connection.commit();
      return newRole;
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return null;
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
        roles.add(buildRole(rs));
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
      if (rs.next()) {
        return buildRole(rs);
      } else {
        throw new ModelBuildException("Can't create role");
      }
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
      st.close();
      connection.commit();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  private Role buildRole(ResultSet rs) throws SQLException {
    return new Role()
        .setId(UUID.fromString(rs.getString("id")))
        .setRoleName(rs.getString("role_name"))
        .setRoleDescription(rs.getString("role_description"));
  }
}
