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

  /**
   * Instantiates a new empty employee.
   */
  public Employee() {}

  /**
   * Instantiates a new employee with full set of data.
   * @param firstName first name of employee
   * @param lastName last name of employee
   * @param patronymic patronymic of employee
   * @param email email of employee
   * @param phone phone of employee
   * @param link link to employee's profile
   * @param specialities specialities of employee
   * @param positions positions of employee
   * @param certificates certificates of employee
   */
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

  /**
   * Gets id of employee.
   * @return id of employee
   */
  public UUID getId() {
    return id;
  }

  /**
   * Sets id of employee.
   * @param id id of employee
   * @return object with new id
   */
  public Employee setId(UUID id) {
    this.id = id;
    return this;
  }

  /**
   * Gets first name of employee.
   * @return first name of employee
   */
  public String getFirstName() {
    return firstName;
  }

  /**
   * Sets first name of employee.
   * @param firstName first name of employee
   * @return object with new first name
   */
  public Employee setFirstName(String firstName) {
    this.firstName = firstName;
    return this;
  }

  /**
   * Get last name of employee.
   * @return last name of employee
   */
  public String getLastName() {
    return lastName;
  }

  /**
   * Sets last name of employee.
   * @param lastName last name of employee
   * @return object with new last name
   */
  public Employee setLastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

  /**
   * Gets patronymic of employee.
   * @return patronymic of employee
   */
  public String getPatronymic() {
    return patronymic;
  }

  /**
   * Sets patronymic of employee.
   * @param patronymic patronymic of employee
   * @return object with new patronymic
   */
  public Employee setPatronymic(String patronymic) {
    this.patronymic = patronymic;
    return this;
  }

  /**
   * Gets email of employee.
   * @return email of employee
   */
  public String getEmail() {
    return email;
  }

  /**
   * Sets email of employee.
   * @param email email of employee
   * @return object with new email
   */
  public Employee setEmail(String email) {
    this.email = email;
    return this;
  }

  /**
   * Gets phone of employee.
   * @return phone of employee
   */
  public String getPhone() {
    return phone;
  }

  /**
   * Sets phone of employee.
   * @param phone phone of employee
   * @return object with new phone
   */
  public Employee setPhone(String phone) {
    this.phone = phone;
    return this;
  }

  /**
   * Gets link to employee's profile.
   * @return link to employee's profile
   */
  public String getLink() {
    return link;
  }

  /**
   * Sets link to employee's profile.
   * @param link link to employee's profile
   * @return object with new link
   */
  public Employee setLink(String link) {
    this.link = link;
    return this;
  }

  /**
   * Gets positions of employee.
   * @return positions of employee
   */
  public List<EmployeePosition> getPositions() {
    return positions;
  }

  /**
   * Sets positions of employee.
   * @param positions positions of employee
   * @return object with new positions
   */
  public Employee setPositions(List<EmployeePosition> positions) {
    this.positions = positions;
    return this;
  }

  /**
   * Gets specialities of employee.
   * @return specialities of employee
   */
  public List<Speciality> getSpecialities() {
    return specialities;
  }

  /**
   * Sets specialities of employee.
   * @param specialities specialities of employee
   * @return object with new specialities
   */
  public Employee setSpeciality(List<Speciality> specialities) {
    this.specialities = specialities;
    return this;
  }

  /**
   * Gets certificates of employee.
   * @return certificates of employee
   */
  public List<Certificate> getCertificates() {
    return certificates;
  }

  /**
   * Sets certificates of employee.
   * @param certificates certificates of employee
   * @return object with new certificates
   */
  public Employee setCertificates(List<Certificate> certificates) {
    this.certificates = certificates;
    return this;
  }
}
