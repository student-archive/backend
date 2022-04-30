package ru.zgz.star.backend.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

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
  private UUID id;
  private Integer result;
  private Instant quizSubmitDate;

  @ManyToOne private Quiz quiz;
  @ManyToOne private User user;

  public void setId(UUID id) {
    this.id = id;
  }

  @Id
  @GeneratedValue
  public UUID getId() {
    return id;
  }

  public void setResult(Integer result) {
    this.result = result;
  }

  public Integer getResult() {
    return result;
  }

  public void setQuizSubmitDate(Instant quizSubmitDate) {
    this.quizSubmitDate = quizSubmitDate;
  }

  public Instant getQuizSubmitDate() {
    return quizSubmitDate;
  }

  public void setQuiz(Quiz quiz) {
    this.quiz = quiz;
  }

  public Quiz getQuiz() {
    return quiz;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public User getUser() {
    return user;
  }
}
