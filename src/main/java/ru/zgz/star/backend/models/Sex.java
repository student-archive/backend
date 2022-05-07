package ru.zgz.star.backend.models;

/**
 * Model for table <code>sex</code>.
 *
 * <p>Storing sexes
 *
 * @author dadyarri
 */
public class Sex {
  private Short id;
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
