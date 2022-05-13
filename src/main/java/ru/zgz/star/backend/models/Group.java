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
  private University university;
  private Speciality speciality;
  private List<User> users;
  private List<Event> events;
  private Collection<Trash> trash;

  /**
   * Instantiates a new Group.
   */
public Group() {}

  /**
   * Instantiates a new Group.
   *
   * @param groupName the group name
   * @param university the university
   * @param speciality the speciality
   * @param users the users
   */
public Group(String groupName, University university, Speciality speciality, List<User> users) {
    this.groupName = groupName;
    this.university = university;
    this.speciality = speciality;
    this.users = users;
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
public Group setSpeciality(Speciality speciality) {
    this.speciality = speciality;
    return this;
  }

  /**
   * Gets speciality.
   *
   * @return the speciality
   */
public Speciality getSpeciality() {
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
   * Gets users.
   *
   * @return the users
   */
public List<User> getUsers() {
    return users;
  }

  /**
   * Sets users.
   *
   * @param users the users
   * @return the users
   */
public Group setUsers(List<User> users) {
    this.users = users;
    return this;
  }

  /**
   * Gets university.
   *
   * @return the university
   */
public University getUniversity() {
    return university;
  }

  /**
   * Sets university.
   *
   * @param university the university
   * @return the university
   */
public Group setUniversity(University university) {
    this.university = university;
    return this;
  }

  /**
   * Gets events.
   *
   * @return the events
   */
public List<Event> getEvents() {
    return events;
  }

  /**
   * Sets events.
   *
   * @param events the events
   * @return the events
   */
public Group setEvents(List<Event> events) {
    this.events = events;
    return this;
  }

  /**
   * Gets trash.
   *
   * @return the trash
   */
public Collection<Trash> getTrash() {
    return trash;
  }

  /**
   * Sets trash.
   *
   * @param trash the trash
   */
public void setTrash(Collection<Trash> trash) {
    this.trash = trash;
  }
}
