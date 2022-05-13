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


  /** Instantiates a new Group. */
  public Group() {}

  /**
   * Instantiates a new Group.
   *
   * @param groupName the group name
   * @param university the university
   * @param speciality the speciality
   */
  public Group(String groupName, UUID university, UUID speciality) {
    this.groupName = groupName;
    this.university = university;
    this.speciality = speciality;
  }

  /**
   * Sets id.
   *
   * @param id the id
   * @return the id
   */
  public Group setId(UUID id) {
    this.id = id;
    return this;
  }

  /**
   * Gets id.
   *
   * @return the id
   */
  public UUID getId() {
    return id;
  }

  /**
   * Sets speciality.
   *
   * @param speciality the speciality
   * @return the speciality
   */
  public Group setSpeciality(UUID speciality) {
    this.speciality = speciality;
    return this;
  }

  /**
   * Gets speciality.
   *
   * @return the speciality
   */
  public UUID getSpeciality() {
    return speciality;
  }

  /**
   * Sets group name.
   *
   * @param groupName the group name
   * @return the group name
   */
  public Group setGroupName(String groupName) {
    this.groupName = groupName;
    return this;
  }

  /**
   * Gets group name.
   *
   * @return the group name
   */
  public String getGroupName() {
    return groupName;
  }

  /**
   * Gets university.
   *
   * @return the university
   */
  public UUID getUniversity() {
    return university;
  }

  /**
   * Sets university.
   *
   * @param university the university
   * @return the university
   */
  public Group setUniversity(UUID university) {
    this.university = university;
    return this;
  }
}
