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

  public Group() {}

  public Group(String groupName, University university, Speciality speciality, List<User> users) {
    this.groupName = groupName;
    this.university = university;
    this.speciality = speciality;
    this.users = users;
  }

  public Group setId(UUID id) {
    this.id = id;
    return this;
  }

  public UUID getId() {
    return id;
  }

  public Group setSpeciality(Speciality speciality) {
    this.speciality = speciality;
    return this;
  }

  public Speciality getSpeciality() {
    return speciality;
  }

  public Group setGroupName(String groupName) {
    this.groupName = groupName;
    return this;
  }

  public String getGroupName() {
    return groupName;
  }

  public List<User> getUsers() {
    return users;
  }

  public Group setUsers(List<User> users) {
    this.users = users;
    return this;
  }

  public University getUniversity() {
    return university;
  }

  public Group setUniversity(University university) {
    this.university = university;
    return this;
  }

  public List<Event> getEvents() {
    return events;
  }

  public Group setEvents(List<Event> events) {
    this.events = events;
    return this;
  }

  public Collection<Trash> getTrash() {
    return trash;
  }

  public void setTrash(Collection<Trash> trash) {
    this.trash = trash;
  }
}
