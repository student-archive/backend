package ru.zgz.star.backend.models;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

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
  @GeneratedValue(generator = "UUID")
  @GenericGenerator(name = "uuid", strategy = "uuid2")
  @Column(name = "id")
  private UUID id;

  @Column(name = "quiz_name")
  private String quizName;

  @Column(name = "quiz_description")
  private String quizDescription;

  @Column(name = "questions_amount")
  private Integer questionsAmount;

  @ManyToOne private Subject subject;

  @OneToMany private Set<Question> questions;

  public Quiz() {}

  public Quiz(
      String quizName,
      String quizDescription,
      Integer questionsAmount,
      Subject subject,
      Set<Question> questions) {
    this.quizName = quizName;
    this.questionsAmount = questionsAmount;
    this.subject = subject;
    this.questions = questions;
  }

  public Quiz setId(UUID id) {
    this.id = id;
    return this;
  }

  public UUID getId() {
    return id;
  }

  public Quiz setQuizName(String quizName) {
    this.quizName = quizName;
    return this;
  }

  public String getQuizName() {
    return quizName;
  }

  public Quiz setQuizDescription(String quizDescription) {
    this.quizDescription = quizDescription;
    return this;
  }

  public String getQuizDescription() {
    return quizDescription;
  }

  public Quiz setQuestionsAmount(Integer amountOfQuestions) {
    this.questionsAmount = amountOfQuestions;
    return this;
  }

  public Integer getQuestionsAmount() {
    return questionsAmount;
  }

  public Quiz setSubject(Subject subject) {
    this.subject = subject;
    return this;
  }

  public Subject getSubject() {
    return subject;
  }

  public Quiz setQuestions(Set<Question> questions) {
    this.questions = questions;
    return this;
  }

  public Set<Question> getQuestions() {
    return questions;
  }
}
