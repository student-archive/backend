package ru.giv.star.api.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Role {
  private @Id String id;
  private String roleName;
  private String roleDescription;

  public String getRoleName() {
    return roleName;
  }

  public String getRoleDescription() {
    return roleDescription;
  }
}
