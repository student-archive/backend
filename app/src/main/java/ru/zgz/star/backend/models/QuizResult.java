package ru.zgz.star.backend.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.util.UUID;
import org.hibernate.annotations.GenericGenerator;

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
  private int result;

  @Column(name = "quiz_submit_date")
  private int quizSubmitDate;

  @ManyToOne
  @JoinColumn(name = "quiz_id")
  private Quiz quiz;

  @ManyToOne
  @JoinColumn(name = "user_id")
  private User user;

  public QuizResult() {}

  public QuizResult(int result, int quizSubmitDate) {
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

  public QuizResult setResult(int result) {
    this.result = result;
    return this;
  }

  public int getResult() {
    return result;
  }

  public QuizResult setQuizSubmitDate(int quizSubmitDate) {
    this.quizSubmitDate = quizSubmitDate;
    return this;
  }

  public int getQuizSubmitDate() {
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
