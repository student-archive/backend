package ru.zgz.star.backend.models;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

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
public class EmployeePosition {
  @Id
  @GeneratedValue(generator = "UUID")
  @GenericGenerator(name = "uuid", strategy = "uuid2")
  @Column(name = "id")
  private UUID id;

  @Column(name = "position")
  private String positionName;

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
}
