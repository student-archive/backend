package ru.zgz.star.backend.models;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

/**
 * Model for table <code>quiz</code>.
 *
 * <p>Storing quizzes
 *
 * @author ironalex
 */
@Entity
@Table(name = "quiz")
public class Quiz {
  @Id
  @GeneratedValue
  @Column(name = "id")
  private UUID id;

  @Column(name = "quiz_name")
  private String quizName;

  @Column(name = "quiz_description")
  private String quizDescription;

  @Column(name = "amount_of_questions")
  private Integer amountOfQuestions;

  @Column(name = "subject_id")
  @ManyToOne
  private Subject subject;

  @OneToMany private Set<Question> questions;

  public Quiz() {}

  public void setId(UUID id) {
    this.id = id;
  }

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
