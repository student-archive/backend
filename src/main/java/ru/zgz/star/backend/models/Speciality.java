package ru.zgz.star.backend.models;

import io.ebean.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;


import java.util.UUID;

/**
 * Model for table <code>speciality</code>.
 *
 * <p>Storing specialities
 *
 * @author dadyarri
 */
@Entity
@Table(name = "speciality")
public class Speciality extends Model {
  @Id
  @GeneratedValue(generator = "UUID")
  
  @Column(name = "id")
  private UUID id;

  @Column(name = "speciality_name")
  private String specialityName;

  @ManyToMany(mappedBy = "specialities")
  public Set<Employee> employees;

  @OneToMany(mappedBy = "speciality")
  private Set<Group> groups;

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

  public Set<Employee> getEmployees() {
    return employees;
  }

  public Speciality setEmployees(Set<Employee> employees) {
    this.employees = employees;
    return this;
  }

  public Set<Group> getGroups() {
    return groups;
  }

  public Speciality setGroups(Set<Group> groups) {
    this.groups = groups;
    return this;
  }
}
