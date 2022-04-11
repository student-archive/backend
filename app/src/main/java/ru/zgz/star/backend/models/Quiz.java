package ru.zgz.star.backend.models;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "quiz")
public class Quiz {
  private UUID id;
  private String quizName;
  private String quizDescription;
  private Integer amountOfQuestions;

  @ManyToOne private Subject subject;
  @OneToMany private Set<Question> questions;

  public void setId(UUID id) {
    this.id = id;
  }

  @Id
  @GeneratedValue
  public UUID getId() {
    return id;
  }

  public void setQuizName(String quizName) {
    this.quizName = quizName;
  }

  public String getQuizName() {
    return quizName;
  }

  public void setQuizDescription(String quizDescription) {
    this.quizDescription = quizDescription;
  }

  public String getQuizDescription() {
    return quizDescription;
  }

  public void setAmountOfQuestions(Integer amountOfQuestions) {
    this.amountOfQuestions = amountOfQuestions;
  }

  public Integer getAmountOfQuestions() {
    return amountOfQuestions;
  }

  public void setSubject(Subject subject) {
    this.subject = subject;
  }

  public Subject getSubject() {
    return subject;
  }

  public void setQuestions(Set<Question> questions) {
    this.questions = questions;
  }

  public Set<Question> getQuestions() {
    return questions;
  }
}
