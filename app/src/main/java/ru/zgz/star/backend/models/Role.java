package ru.zgz.star.backend.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
  private UUID id;
  private String roleName;
  private String roleDescription;

  public void setId(UUID id) {
    this.id = id;
  }

  @Id
  @GeneratedValue
  public UUID getId() {
    return id;
  }

  public void setRoleName(String roleName) {
    this.roleName = roleName;
  }

  public String getRoleName() {
    return roleName;
  }

  public void setRoleDescription(String roleDescription) {
    this.roleDescription = roleDescription;
  }

  public String getRoleDescription() {
    return roleDescription;
  }
}
