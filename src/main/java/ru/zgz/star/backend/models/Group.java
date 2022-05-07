package ru.zgz.star.backend.models;

import io.ebean.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Collection;


import java.util.Set;
import java.util.UUID;

/**
 * Model for table <code>group</code>.
 *
 * <p>Storing groups
 *
 * @author dadyarri
 */
@Entity
@Table(name = "group")
public class Group extends Model {
  @Id
  @GeneratedValue(generator = "UUID")
  
  @Column(name = "id")
  private UUID id;

  @Column(name = "group_name")
  private String groupName;

  @ManyToOne
  @JoinColumn(name = "university_id", nullable = false)
  private University university;

  @ManyToOne
  @JoinColumn(name = "speciality_id")
  private Speciality speciality;

  @OneToMany(mappedBy = "group")
  private Set<User> users;

  @OneToMany(mappedBy = "group")
  private Set<Event> events;

  @OneToMany(mappedBy = "group")
  private Collection<Trash> trash;

  public Group() {}

  public Group(String groupName, University university, Speciality speciality, Set<User> users) {
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

  public Set<User> getUsers() {
    return users;
  }

  public Group setUsers(Set<User> users) {
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

  public Set<Event> getEvents() {
    return events;
  }

  public Group setEvents(Set<Event> events) {
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
