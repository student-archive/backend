package ru.zgz.star.backend.models;

import java.util.List;
import java.util.UUID;

/**
 * Model for table <code>role</code>.
 *
 * <p>Storing roles
 *
 * @author dadyarri
 */
public class Role {

  private UUID id;
  private String roleName;
  private String roleDescription;
  private List<User> users;

  public Role() {}

  public Role(String roleName, String roleDescription) {
    this.roleName = roleName;
    this.roleDescription = roleDescription;
  }

  public Role setId(UUID id) {
    this.id = id;
    return this;
  }

  public UUID getId() {
    return id;
  }

  public Role setRoleName(String roleName) {
    this.roleName = roleName;
    return this;
  }

  public String getRoleName() {
    return roleName;
  }

  public Role setRoleDescription(String roleDescription) {
    this.roleDescription = roleDescription;
    return this;
  }

  public String getRoleDescription() {
    return roleDescription;
  }

  public List<User> getUsers() {
    return users;
  }

  public Role setUsers(List<User> users) {
    this.users = users;
    return this;
  }
}
