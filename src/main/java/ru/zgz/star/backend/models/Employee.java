package ru.zgz.star.backend.models;

import java.util.List;
import java.util.UUID;

/**
 * Model for table <code>employee</code>.
 *
 * <p>Storing employees
 *
 * @author dadyarri
 */
public class Employee {
  private UUID id;
  private String firstName;
  private String lastName;
  private String patronymic;
  private String email;
  private String phone;
  private String link;
  private List<Speciality> specialities;
  private List<EmployeePosition> positions;
  private List<Certificate> certificates;

  public Employee() {}

  public Employee(
      String firstName,
      String lastName,
      String patronymic,
      String email,
      String phone,
      String link,
      List<Speciality> specialities,
      List<EmployeePosition> positions,
      List<Certificate> certificates) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.patronymic = patronymic;
    this.email = email;
    this.phone = phone;
    this.link = link;
    this.specialities = specialities;
    this.positions = positions;
    this.certificates = certificates;
  }

  public UUID getId() {
    return id;
  }

  public Employee setId(UUID id) {
    this.id = id;
    return this;
  }

  public String getFirstName() {
    return firstName;
  }

  public Employee setFirstName(String firstName) {
    this.firstName = firstName;
    return this;
  }

  public String getLastName() {
    return lastName;
  }

  public Employee setLastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

  public String getPatronymic() {
    return patronymic;
  }

  public Employee setPatronymic(String patronymic) {
    this.patronymic = patronymic;
    return this;
  }

  public String getEmail() {
    return email;
  }

  public Employee setEmail(String email) {
    this.email = email;
    return this;
  }

  public String getPhone() {
    return phone;
  }

  public Employee setPhone(String phone) {
    this.phone = phone;
    return this;
  }

  public String getLink() {
    return link;
  }

  public Employee setLink(String link) {
    this.link = link;
    return this;
  }

  public List<EmployeePosition> getPositions() {
    return positions;
  }

  public Employee setPositions(List<EmployeePosition> positions) {
    this.positions = positions;
    return this;
  }

  public List<Speciality> getSpecialities() {
    return specialities;
  }

  public Employee setSpeciality(List<Speciality> specialities) {
    this.specialities = specialities;
    return this;
  }

  public List<Certificate> getCertificates() {
    return certificates;
  }

  public Employee setCertificates(List<Certificate> certificates) {
    this.certificates = certificates;
    return this;
  }
}
