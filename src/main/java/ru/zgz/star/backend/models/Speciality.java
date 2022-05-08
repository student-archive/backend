package ru.zgz.star.backend.models;

import java.util.List;
import java.util.UUID;

/**
 * Model for table <code>speciality</code>.
 *
 * <p>Storing specialities
 *
 * @author dadyarri
 */
public class Speciality {
  private UUID id;
  private String specialityName;
  public List<Employee> employees;
  private List<Group> groups;

  public Speciality() {}

  public Speciality(String specialityName) {
    this.specialityName = specialityName;
  }

  public Speciality setId(UUID id) {
    this.id = id;
    return this;
  }

  public UUID getId() {
    return id;
  }

  public Speciality setSpecialityName(String specialityName) {
    this.specialityName = specialityName;
    return this;
  }

  public String getSpecialityName() {
    return specialityName;
  }

  public List<Employee> getEmployees() {
    return employees;
  }

  public Speciality setEmployees(List<Employee> employees) {
    this.employees = employees;
    return this;
  }

  public List<Group> getGroups() {
    return groups;
  }

  public Speciality setGroups(List<Group> groups) {
    this.groups = groups;
    return this;
  }
}
