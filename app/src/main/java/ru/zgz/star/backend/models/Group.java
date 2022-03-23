package ru.zgz.star.backend.models;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "group")
public class Group {
  private UUID id;
  private String groupName;

  @ManyToOne private Speciality speciality;
  @OneToMany private Set<User> users;

  public void setId(UUID id) {
    this.id = id;
  }

  @Id
  @GeneratedValue
  public UUID getId() {
    return id;
  }

  public void setSpeciality(Speciality speciality) {
    this.speciality = speciality;
  }

  public Speciality getSpeciality() {
    return speciality;
  }

  public void setGroupName(String groupName) {
    this.groupName = groupName;
  }

  public String getGroupName() {
    return groupName;
  }

  public Set<User> getUsers() {
    return users;
  }

  public void setUsers(Set<User> users) {
    this.users = users;
  }
}
