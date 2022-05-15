package ru.zgz.star.backend.models;

import java.util.UUID;

/**
 * Model for table <code>tutor</code>.
 *
 * <p>Storing tutors
 *
 * @author dadyarri
 */
public class Tutor {
  private UUID id;
  private String firstName;
  private String lastName;
  private String patronymic;
  private String email;
  private String phone;
  private String link;
  private Boolean isWorking;

  public Tutor() {}

  public Tutor(
      String firstName,
      String lastName,
      String patronymic,
      String email,
      String phone,
      String link,
      Boolean isWorking) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.patronymic = patronymic;
    this.email = email;
    this.phone = phone;
    this.link = link;
    this.isWorking = isWorking;
  }

  public UUID getId() {
    return id;
  }

  public Tutor setId(UUID id) {
    this.id = id;
    return this;
  }

  public String getFirstName() {
    return firstName;
  }

  public Tutor setFirstName(String firstName) {
    this.firstName = firstName;
    return this;
  }

  public String getLastName() {
    return lastName;
  }

  public Tutor setLastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

  public String getPatronymic() {
    return patronymic;
  }

  public Tutor setPatronymic(String patronymic) {
    this.patronymic = patronymic;
    return this;
  }

  public String getEmail() {
    return email;
  }

  public Tutor setEmail(String email) {
    this.email = email;
    return this;
  }

  public String getPhone() {
    return phone;
  }

  public Tutor setPhone(String phone) {
    this.phone = phone;
    return this;
  }

  public String getLink() {
    return link;
  }

  public Tutor setLink(String link) {
    this.link = link;
    return this;
  }

  public Boolean isIsWorking() {
    return isWorking;
  }

  public Tutor setIsWorking(Boolean isWorking) {
    this.isWorking = isWorking;
    return this;
  }
}
