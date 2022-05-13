package ru.zgz.star.backend.models;

import java.util.UUID;

/**
 * Model for table <code>speciality</code>.
 *
 * <p>Storing specialities
 *
 * @author dadyarri
 */
public class Speciality {
  private UUID id;
  private String specialityName;

  public Speciality() {}

  public Speciality(String specialityName) {
    this.specialityName = specialityName;
  }

  public Speciality setId(UUID id) {
    this.id = id;
    return this;
  }

  public UUID getId() {
    return id;
  }

  public Speciality setSpecialityName(String specialityName) {
    this.specialityName = specialityName;
    return this;
  }

  public String getSpecialityName() {
    return specialityName;
  }
}
