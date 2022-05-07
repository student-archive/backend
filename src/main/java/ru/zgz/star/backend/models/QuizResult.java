package ru.zgz.star.backend.models;

import java.util.UUID;

/**
 * Model for table <code>quiz_result</code>.
 *
 * <p>Storing results of quizzes walkthroughs
 *
 * @author ironalex
 */
public class QuizResult {

  private UUID id;
  private Integer result;
  private Integer quizSubmitDate;
  private Quiz quiz;
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
