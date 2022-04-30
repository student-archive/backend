package ru.zgz.star.backend.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

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
public class Group {
  @Id
  @GeneratedValue(generator = "UUID")
  @GenericGenerator(name = "uuid", strategy = "uuid2")
  @Column(name = "id")
  private UUID id;

  @Column(name = "group_name")
  private String groupName;

  @ManyToOne private University university;
  @ManyToOne private Speciality speciality;
  @OneToMany private Set<User> users;

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
}
