package ru.zgz.star.backend.models;

import io.ebean.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.Set;
import java.util.UUID;


/**
 * Model for table <code>employee_position</code>.
 *
 * <p>Storing positions of employees
 *
 * @author dadyarri
 */
@Entity
@Table(name = "employee_position")
public class EmployeePosition extends Model {
  @Id
  @GeneratedValue(generator = "UUID")
  
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
