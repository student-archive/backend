package ru.zgz.star.backend.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

/**
 * Model for table <code>tutor</code>.
 *
 * <p>Storing tutors
 *
 * @author dadyarri
 */
@Entity
@Table(name = "tutor")
public class Tutor {
  private UUID id;
  private String firstName;
  private String lastName;
  private String patronymic;
  private String email;
  private String phone;
  private String link;
  private boolean isWorking;

  @Id
  @GeneratedValue
  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getPatronymic() {
    return patronymic;
  }

  public void setPatronymic(String patronymic) {
    this.patronymic = patronymic;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public String getLink() {
    return link;
  }

  public void setLink(String link) {
    this.link = link;
  }

  public boolean isIsWorking() {
    return isWorking;
  }

  public void setIsWorking(boolean isWorking) {
    this.isWorking = isWorking;
  }
}
