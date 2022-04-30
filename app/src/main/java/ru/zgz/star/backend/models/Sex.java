package ru.zgz.star.backend.models;

import jakarta.persistence.Column;
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
  @Id
  @Column(name = "id")
  private Short id;

  @Column(name = "sex_name")
  private String sexName;

  public Sex() {}

  public Sex(String sexName){
    this.sexName = sexName;
  }

  public Short getId() {
    return id;
  }

  public Sex setId(Short id) {
    this.id = id;
    return this;
  }

  public String getSexName() {
    return sexName;
  }

  public Sex setSexName(String sexName) {
    this.sexName = sexName;
    return this;
  }
}
