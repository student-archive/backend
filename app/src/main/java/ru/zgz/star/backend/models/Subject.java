package ru.zgz.star.backend.models;
import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "subject")
public class Subject {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private UUID id;

  @ManyToOne
  @JoinColumn(name = "group_id")
  private Group group;
  private String subjectName;
  private int semester;

  public UUID getId() {
    return id;
  }
  public void setId(UUID id) {
    this.id = id;
  }
  public Group getGroup() {
    return group;
  }
  public void setGroup(Group group) {
    this.group = group;
  }
  public String getSubjectName() {
    return subjectName;
  }
  public void setSubjectName(String subjectName) {
    this.subjectName = subjectName;
  }
  public int getSemester() {
    return semester;
  }
  public void setSemester(int semester) {
    this.semester = semester;
  }
}
