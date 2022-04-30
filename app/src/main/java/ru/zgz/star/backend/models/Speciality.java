package ru.zgz.star.backend.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

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
