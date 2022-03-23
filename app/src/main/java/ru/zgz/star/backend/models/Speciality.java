package ru.zgz.star.backend.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

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
