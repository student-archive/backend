package ru.zgz.star.backend.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.Set;
import org.hibernate.annotations.GenericGenerator;

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
public class Speciality {
  @Id
  @GeneratedValue(generator = "UUID")
  @GenericGenerator(name = "uuid", strategy = "uuid2")
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
