package ru.zgz.star.backend.models;

import jakarta.persistence.*;
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
}
