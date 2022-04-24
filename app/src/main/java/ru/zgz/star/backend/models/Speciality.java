package ru.zgz.star.backend.models;

import javax.persistence.*;
import java.util.UUID;

/**
 * Model for table <code>speciality</code>.
 *
 * <p>Storing specialities
 *
 * @author dadyarri
 */
@Entity
@Table(name = "speciality")
public class Speciality {
  private UUID id;
  private String specialityName;

  public void setId(UUID id) {
    this.id = id;
  }

  @Id
  @GeneratedValue
  public UUID getId() {
    return id;
  }

  public void setSpecialityName(String specialityName) {
    this.specialityName = specialityName;
  }

  public String getSpecialityName() {
    return specialityName;
  }
}
