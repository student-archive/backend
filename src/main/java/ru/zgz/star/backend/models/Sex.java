package ru.zgz.star.backend.models;

import io.ebean.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Model for table <code>sex</code>.
 *
 * <p>Storing sexes
 *
 * @author dadyarri
 */
@Entity
@Table(name = "sex")
public class Sex extends Model {
  @Id
  @Column(name = "id")
  private Short id;

  @Column(name = "sex_name")
  private String sexName;

  public Sex() {}

  public Sex(String sexName) {
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
