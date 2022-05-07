package ru.zgz.star.backend.models;

import java.util.List;
import java.util.UUID;

/**
 * Model for table <code>university</code>.
 *
 * <p>Storing universities
 *
 * @author dadyarri
 */
public class University {

  private UUID id;
  private String universityName;
  private List<Group> groups;

  public University() {}

  public University(String universityName) {
    this.universityName = universityName;
  }

  public UUID getId() {
    return id;
  }

  public University setId(UUID id) {
    this.id = id;
    return this;
  }

  public String getUniversityName() {
    return universityName;
  }

  public University setUniversityName(String universityName) {
    this.universityName = universityName;
    return this;
  }

  public List<Group> getGroups() {
    return groups;
  }

  public University setGroups(List<Group> groups) {
    this.groups = groups;
    return this;
  }
}
