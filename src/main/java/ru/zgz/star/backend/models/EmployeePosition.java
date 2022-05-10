package ru.zgz.star.backend.models;

import java.util.List;
import java.util.UUID;

/**
 * Model for table <code>employee_position</code>.
 *
 * <p>Storing positions of employees
 *
 * @author dadyarri
 */
public class EmployeePosition {
  private UUID id;
  private String positionName;
  private List<Employee> employees;

  /** Instantiates a new empty Employee position. */
  public EmployeePosition() {}

  /**
   * Instantiates a new Employee position.
   *
   * @param positionName the position name
   */
  public EmployeePosition(String positionName) {
    this.positionName = positionName;
  }

  /**
   * Gets id of the position.
   *
   * @return the id
   */
  public UUID getId() {
    return id;
  }

  /**
   * Sets id of the position.
   *
   * @param id the id
   * @return object with new id
   */
  public EmployeePosition setId(UUID id) {
    this.id = id;
    return this;
  }

  /**
   * Gets position name.
   *
   * @return the position name
   */
  public String getPositionName() {
    return positionName;
  }

  /**
   * Sets position name.
   *
   * @param positionName the position name
   * @return object with new position name
   */
  public EmployeePosition setPositionName(String positionName) {
    this.positionName = positionName;
    return this;
  }

  /**
   * Gets employees on this position.
   *
   * @return the employees
   */
  public List<Employee> getEmployees() {
    return employees;
  }

  /**
   * Sets employees on this position.
   *
   * @param employees the employees
   * @return object with new employees
   */
  public EmployeePosition setEmployees(List<Employee> employees) {
    this.employees = employees;
    return this;
  }
}
