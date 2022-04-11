package ru.zgz.star.backend.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sex")
public class Sex {
  private Short id;
  private String sexName;

  @Id
  public Short getId() {
    return id;
  }

  public void setId(Short id) {
    this.id = id;
  }

  public String getSexName() {
    return sexName;
  }

  public void setSexName(String sexName) {
    this.sexName = sexName;
  }
}
