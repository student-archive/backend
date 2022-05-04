package ru.zgz.star.backend.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import java.util.Set;
import java.util.UUID;
import org.hibernate.annotations.GenericGenerator;

/**
 * Model for table <code>employee_position</code>.
 *
 * <p>Storing positions of employees
 *
 * @author dadyarri
 */
@Entity
@Table(name = "employee_position")
public class EmployeePosition {
  @Id
  @GeneratedValue(generator = "UUID")
  @GenericGenerator(name = "uuid", strategy = "uuid2")
  @Column(name = "id")
  private UUID id;

  @Column(name = "position")
  private String positionName;

  @ManyToMany(mappedBy = "positions")
  public Set<Employee> employees;

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

  public Set<Employee> getEmployees() {
    return employees;
  }

  public EmployeePosition setEmployees(Set<Employee> employees) {
    this.employees = employees;
    return this;
  }
}
