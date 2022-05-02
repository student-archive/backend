package ru.zgz.star.backend.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.Set;
import org.hibernate.annotations.GenericGenerator;

/**
 * Model for table <code>university</code>.
 *
 * <p>Storing universities
 *
 * @author dadyarri
 */
@Entity
@Table(name = "university")
public class University {
  @Id
  @GeneratedValue(generator = "UUID")
  @GenericGenerator(name = "uuid", strategy = "uuid2")
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
