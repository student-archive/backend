package ru.zgz.star.backend.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

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

  @ManyToMany private Set<Speciality> specialities;
  @ManyToMany private Set<EmployeePosition> positions;
  @ManyToMany private Set<Certificate> certificates;

  public Employee() {}

  public Employee(
      String firstName,
      String lastName,
      String patronymic,
      String email,
      String phone,
      String link,
      Set<Speciality> specialities,
      Set<EmployeePosition> positions,
      Set<Certificate> certificates) {
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

  public Set<EmployeePosition> getPositions() {
    return positions;
  }

  public Employee setPositions(Set<EmployeePosition> positions) {
    this.positions = positions;
    return this;
  }

  public Set<Speciality> getSpecialities() {
    return specialities;
  }

  public Employee setSpeciality(Set<Speciality> specialities) {
    this.specialities = specialities;
    return this;
  }

  public Set<Certificate> getCertificates() {
    return certificates;
  }

  public Employee setCertificates(Set<Certificate> certificates) {
    this.certificates = certificates;
    return this;
  }
}
