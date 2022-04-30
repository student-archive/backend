package ru.zgz.star.backend.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

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

  @Column(name = "questions_amount")
  private Integer questionsAmount;

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

  public void setQuestionsAmount(Integer amountOfQuestions) {
    this.questionsAmount = amountOfQuestions;
  }

  public Integer getQuestionsAmount() {
    return questionsAmount;
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
