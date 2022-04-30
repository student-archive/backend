package ru.zgz.star.backend.models;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.time.Instant;
import java.util.UUID;

/**
 * Model for table <code>quiz_result</code>.
 *
 * <p>Storing results of quizzes walkthroughs
 *
 * @author ironalex
 */
@Entity
@Table(name = "quiz_result")
public class QuizResult {
  @Id
  @GeneratedValue(generator = "UUID")
  @GenericGenerator(name = "uuid", strategy = "uuid2")
  @Column(name = "id")
  private UUID id;

  @Column(name = "result")
  private Integer result;

  @Column(name = "quiz_submit_date")
  private Instant quizSubmitDate;

  @ManyToOne private Quiz quiz;
  @ManyToOne private User user;

  public QuizResult() {}

  public QuizResult(
    Integer result,Instant quizSubmitDate) {
    this.result = result;
    this.quizSubmitDate = quizSubmitDate;
  }

  public QuizResult setId(UUID id) {
    this.id = id;
    return this;
  }

  public UUID getId() {
    return id;
  }

  public QuizResult setResult(Integer result) {
    this.result = result;
    return this;
  }

  public Integer getResult() {
    return result;
  }

  public QuizResult setQuizSubmitDate(Instant quizSubmitDate) {
    this.quizSubmitDate = quizSubmitDate;
    return this;
  }

  public Instant getQuizSubmitDate() {
    return quizSubmitDate;
  }

  public QuizResult setQuiz(Quiz quiz) {
    this.quiz = quiz;
    return this;
  }

  public Quiz getQuiz() {
    return quiz;
  }

  public QuizResult setUser(User user) {
    this.user = user;
    return this;
  }

  public User getUser() {
    return user;
  }
}
