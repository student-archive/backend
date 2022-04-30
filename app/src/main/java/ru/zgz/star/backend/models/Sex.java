package ru.zgz.star.backend.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Model for table <code>sex</code>.
 *
 * <p>Storing sexes
 *
 * @author dadyarri
 */
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
