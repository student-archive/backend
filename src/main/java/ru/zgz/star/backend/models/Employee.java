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


  /** Instantiates a new empty employee. */
  public Employee() {}

  /**
   * Instantiates a new employee with full set of data.
   *
   * @param firstName first name of employee
   * @param lastName last name of employee
   * @param patronymic patronymic of employee
   * @param email email of employee
   * @param phone phone of employee
   * @param link link to employee's profile

   */
  public Employee(
      String firstName,
      String lastName,
      String patronymic,
      String email,
      String phone,
      String link)
 {
    this.firstName = firstName;
    this.lastName = lastName;
    this.patronymic = patronymic;
    this.email = email;
    this.phone = phone;
    this.link = link;

  }

  /**
   * Gets id of employee.
   *
   * @return id of employee
   */
  public UUID getId() {
    return id;
  }

  /**
   * Sets id of employee.
   *
   * @param id id of employee
   * @return object with new id
   */
  public Employee setId(UUID id) {
    this.id = id;
    return this;
  }

  /**
   * Gets first name of employee.
   *
   * @return first name of employee
   */
  public String getFirstName() {
    return firstName;
  }

  /**
   * Sets first name of employee.
   *
   * @param firstName first name of employee
   * @return object with new first name
   */
  public Employee setFirstName(String firstName) {
    this.firstName = firstName;
    return this;
  }

  /**
   * Get last name of employee.
   *
   * @return last name of employee
   */
  public String getLastName() {
    return lastName;
  }

  /**
   * Sets last name of employee.
   *
   * @param lastName last name of employee
   * @return object with new last name
   */
  public Employee setLastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

  /**
   * Gets patronymic of employee.
   *
   * @return patronymic of employee
   */
  public String getPatronymic() {
    return patronymic;
  }

  /**
   * Sets patronymic of employee.
   *
   * @param patronymic patronymic of employee
   * @return object with new patronymic
   */
  public Employee setPatronymic(String patronymic) {
    this.patronymic = patronymic;
    return this;
  }

  /**
   * Gets email of employee.
   *
   * @return email of employee
   */
  public String getEmail() {
    return email;
  }

  /**
   * Sets email of employee.
   *
   * @param email email of employee
   * @return object with new email
   */
  public Employee setEmail(String email) {
    this.email = email;
    return this;
  }

  /**
   * Gets phone of employee.
   *
   * @return phone of employee
   */
  public String getPhone() {
    return phone;
  }

  /**
   * Sets phone of employee.
   *
   * @param phone phone of employee
   * @return object with new phone
   */
  public Employee setPhone(String phone) {
    this.phone = phone;
    return this;
  }

  /**
   * Gets link to employee's profile.
   *
   * @return link to employee's profile
   */
  public String getLink() {
    return link;
  }

  /**
   * Sets link to employee's profile.
   *
   * @param link link to employee's profile
   * @return object with new link
   */
  public Employee setLink(String link) {
    this.link = link;
    return this;
  }
}
