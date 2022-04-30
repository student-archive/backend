package ru.zgz.star.backend.models;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;

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
}
