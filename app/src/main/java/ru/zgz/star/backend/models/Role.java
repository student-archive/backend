package ru.zgz.star.backend.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.Set;
import java.util.UUID;
import org.hibernate.annotations.GenericGenerator;

/**
 * Model for table <code>role</code>.
 *
 * <p>Storing roles
 *
 * @author dadyarri
 */
@Entity
@Table(name = "role")
public class Role {
  @Id
  @GeneratedValue(generator = "UUID")
  @GenericGenerator(name = "uuid", strategy = "uuid2")
  @Column(name = "id")
  private UUID id;

  @Column(name = "role_name")
  private String roleName;

  @Column(name = "role_description")
  private String roleDescription;

  @OneToMany(mappedBy = "role")
  private Set<User> users;

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

  public Set<User> getUsers() {
    return users;
  }

  public Role setUsers(Set<User> users) {
    this.users = users;
    return this;
  }
}
