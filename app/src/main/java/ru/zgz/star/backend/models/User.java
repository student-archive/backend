package ru.zgz.star.backend.models;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "user")
public class User {
  private UUID id;
  private String firstName;
  private String lastName;

  @ManyToOne private Role role;

  public void setId(UUID id) {
    this.id = id;
  }

  @Id
  @GeneratedValue
  public UUID getId() {
    return id;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setRole(Role role) {
    this.role = role;
  }

  public Role getRole() {
    return role;
  }
}
