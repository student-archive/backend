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
  private Group group;
  private List<Page> pages;
  private List<Quiz> quizzes;
  private List<Software> software;
  private List<Tutor> tutors;
  private String subjectName;
  private Integer semester;

  public Subject() {}

  public Subject(Group group, String subjectName, Integer semester) {
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

  public Group getGroup() {
    return group;
  }

  public Subject setGroup(Group group) {
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

  public List<Page> getPages() {
    return pages;
  }

  public Subject setPages(List<Page> pages) {
    this.pages = pages;
    return this;
  }

  public List<Quiz> getQuizzes() {
    return quizzes;
  }

  public Subject setQuizzes(List<Quiz> quizzes) {
    this.quizzes = quizzes;
    return this;
  }

  public List<Software> getSoftware() {
    return software;
  }

  public Subject setSoftware(List<Software> software) {
    this.software = software;
    return this;
  }

  public List<Tutor> getTutors() {
    return tutors;
  }

  public Subject setTutors(List<Tutor> tutors) {
    this.tutors = tutors;
    return this;
  }
}
