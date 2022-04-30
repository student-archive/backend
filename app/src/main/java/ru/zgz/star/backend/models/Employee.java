package ru.zgz.star.backend.models;

import jakarta.persistence.*;
import java.util.Set;
import java.util.UUID;

/**
 * Model for table <code>employee</code>.
 *
 * <p>Storing employees
 *
 * @author dadyarri
 */
@Entity
@Table(name = "employee")
public class Employee {
  private UUID id;
  private String firstName;
  private String lastName;
  private String patronymic;
  private String email;
  private String phone;
  private String link;
  @ManyToMany private Set<Speciality> specialities;
  @ManyToMany private Set<EmployeePosition> positions;
  @ManyToMany private Set<Certificate> certificates;

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

  public Set<EmployeePosition> getPositions() {
    return positions;
  }

  public void setPositions(Set<EmployeePosition> positions) {
    this.positions = positions;
  }

  public Set<Speciality> getSpecialities() {
    return specialities;
  }

  public void setSpeciality(Set<Speciality> specialities) {
    this.specialities = specialities;
  }

  public Set<Certificate> getCertificates() {
    return certificates;
  }

  public void setCertificates(Set<Certificate> certificates) {
    this.certificates = certificates;
  }
}
