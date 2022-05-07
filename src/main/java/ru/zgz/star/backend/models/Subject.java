package ru.zgz.star.backend.models;

import io.ebean.Model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;
import java.util.UUID;


/**
 * Model for table <code>subject</code>.
 *
 * <p>Storing subjects
 *
 * @author dadyarri
 */
@Entity
@Table(name = "subject")
public class Subject extends Model {
  @Id
  @GeneratedValue(generator = "UUID")
  
  @Column(name = "id")
  private UUID id;

  @ManyToOne
  @JoinColumn(name = "group_id")
  private Group group;

  @OneToMany(mappedBy = "subject")
  private Set<Page> pages;

  @OneToMany(mappedBy = "subject")
  private Set<Quiz> quizzes;

  @OneToMany(mappedBy = "subject")
  private Set<Software> software;

  @ManyToMany(cascade = CascadeType.ALL)
  @JoinTable(
      name = "subject_tutor",
      joinColumns = @JoinColumn(name = "subject_id"),
      inverseJoinColumns = @JoinColumn(name = "tutor_id"))
  private Set<Tutor> tutors;

  @Column(name = "subject_name")
  private String subjectName;

  @Column(name = "semester")
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

  public Set<Page> getPages() {
    return pages;
  }

  public Subject setPages(Set<Page> pages) {
    this.pages = pages;
    return this;
  }

  public Set<Quiz> getQuizzes() {
    return quizzes;
  }

  public Subject setQuizzes(Set<Quiz> quizzes) {
    this.quizzes = quizzes;
    return this;
  }

  public Set<Software> getSoftware() {
    return software;
  }

  public Subject setSoftware(Set<Software> software) {
    this.software = software;
    return this;
  }

  public Set<Tutor> getTutors() {
    return tutors;
  }

  public Subject setTutors(Set<Tutor> tutors) {
    this.tutors = tutors;
    return this;
  }
}