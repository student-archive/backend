package ru.zgz.star.backend.models;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

/**
 * Model for table <code>group</code>.
 *
 * <p>Storing groups
 *
 * @author dadyarri
 */

public class Group {

  private UUID id;
  private String groupName;
  private UUID university;
  private UUID speciality;


  public Group() {}

  public Group(String groupName, UUID university, UUID speciality) {
    this.groupName = groupName;
    this.university = university;
    this.speciality = speciality;
  }

  public Group setId(UUID id) {
    this.id = id;
    return this;
  }

  public UUID getId() {
    return id;
  }

  public Group setSpeciality(UUID speciality) {
    this.speciality = speciality;
    return this;
  }

  public UUID getSpeciality() {
    return speciality;
  }

  public Group setGroupName(String groupName) {
    this.groupName = groupName;
    return this;
  }

  public String getGroupName() {
    return groupName;
  }


  public UUID getUniversity() {
    return university;
  }

  public Group setUniversity(UUID university) {
    this.university = university;
    return this;
  }
}
