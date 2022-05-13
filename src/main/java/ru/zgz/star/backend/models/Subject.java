package ru.zgz.star.backend.models;

import java.util.List;
import java.util.UUID;

/**
 * Model for table <code>subject</code>.
 *
 * <p>Storing subjects
 *
 * @author dadyarri
 */
public class Subject {
  private UUID id;
  private UUID group;
  private String subjectName;
  private Integer semester;

  public Subject() {}

  public Subject(UUID group, String subjectName, Integer semester) {
    this.group = group;
    this.subjectName = subjectName;
    this.semester = semester;
  }

  public UUID getId() {
    return id;
  }

  public Subject setId(UUID id) {
    this.id = id;
    return this;
  }

  public UUID getGroup() {
    return group;
  }

  public Subject setGroup(UUID group) {
    this.group = group;
    return this;
  }

  public String getSubjectName() {
    return subjectName;
  }

  public Subject setSubjectName(String subjectName) {
    this.subjectName = subjectName;
    return this;
  }

  public Integer getSemester() {
    return semester;
  }

  public Subject setSemester(Integer semester) {
    this.semester = semester;
    return this;
  }
}
