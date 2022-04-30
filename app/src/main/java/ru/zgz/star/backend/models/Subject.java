package ru.zgz.star.backend.models;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

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
public class Subject {
  @Id
  @GeneratedValue(generator = "UUID")
  @GenericGenerator(name = "uuid", strategy = "uuid2")
  @Column(name = "id")
  private UUID id;

  @ManyToOne
  @JoinColumn(name = "group_id")

  @Column(name = "group_id")
  private Group group;

  @Column(name = "subject_name")
  private String subjectName;

  @Column(name = "semester")
  private int semester;

  public Subject() {}

  public Subject(Group group,String subjectName,int semester) {
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
  public int getSemester() {
    return semester;
  }
  public Subject setSemester(int semester) {
    this.semester = semester;
    return this;
  }
}
