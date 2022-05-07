package ru.zgz.star.backend.models;

import io.ebean.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.Collection;


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
public class Tutor extends Model {
  @Id
  @GeneratedValue(generator = "UUID")
  
  @Column(name = "id")
  private UUID id;

  @Column(name = "first_name")
  private String firstName;

  @Column(name = "last_name")
  private String lastName;

  @Column(name = "patronymic")
  private String patronymic;

  @Column(name = "email")
  private String email;

  @Column(name = "phone")
  private String phone;

  @Column(name = "link")
  private String link;

  @Column(name = "is_working")
  private Boolean isWorking;

  @ManyToMany(mappedBy = "tutors")
  private Collection<Subject> subjects;

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

  public Collection<Subject> getSubjects() {
    return subjects;
  }

  public void setSubjects(Collection<Subject> subjects) {
    this.subjects = subjects;
  }
}
