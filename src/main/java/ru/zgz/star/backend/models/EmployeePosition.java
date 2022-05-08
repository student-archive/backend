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
  public List<Employee> employees;

  public EmployeePosition() {}

  public EmployeePosition(String positionName) {
    this.positionName = positionName;
  }

  public UUID getId() {
    return id;
  }

  public EmployeePosition setId(UUID id) {
    this.id = id;
    return this;
  }

  public String getPositionName() {
    return positionName;
  }

  public EmployeePosition setPositionName(String positionName) {
    this.positionName = positionName;
    return this;
  }

  public List<Employee> getEmployees() {
    return employees;
  }

  public EmployeePosition setEmployees(List<Employee> employees) {
    this.employees = employees;
    return this;
  }
}
