package ru.zgz.star.backend.models;

import io.ebean.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
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
public class QuizResult extends Model {
  @Id
  @GeneratedValue(generator = "UUID")
  
  @Column(name = "id")
  private UUID id;

  @Column(name = "result")
  private Integer result;

  @Column(name = "quiz_submit_date")
  private Integer quizSubmitDate;

  @ManyToOne
  @JoinColumn(name = "quiz_id")
  private Quiz quiz;

  @ManyToOne
  @JoinColumn(name = "user_id")
  private User user;

  public QuizResult() {}

  public QuizResult(Integer result, Integer quizSubmitDate) {
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

  public QuizResult setQuizSubmitDate(Integer quizSubmitDate) {
    this.quizSubmitDate = quizSubmitDate;
    return this;
  }

  public Integer getQuizSubmitDate() {
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
