package ru.zgz.star.backend.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import java.util.Collection;
import org.hibernate.annotations.GenericGenerator;

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
  @Id
  @GeneratedValue(generator = "UUID")
  @GenericGenerator(name = "uuid", strategy = "uuid2")
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
