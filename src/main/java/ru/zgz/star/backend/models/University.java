package ru.zgz.star.backend.models;

import io.ebean.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;


/**
 * Model for table <code>university</code>.
 *
 * <p>Storing universities
 *
 * @author dadyarri
 */
@Entity
@Table(name = "university")
public class University extends Model {
  @Id
  @GeneratedValue(generator = "UUID")
  
  @Column(name = "id")
  private String id;

  @Column(name = "university_name")
  private String universityName;

  @OneToMany(mappedBy = "university")
  private Set<Group> groups;

  public University() {}

  public University(String universityName) {
    this.universityName = universityName;
  }

  public String getId() {
    return id;
  }

  public University setId(String id) {
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

  public Set<Group> getGroups() {
    return groups;
  }

  public University setGroups(Set<Group> groups) {
    this.groups = groups;
    return this;
  }
}
