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
  private UUID quiz;
  private UUID user;

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

  public QuizResult setQuiz(UUID quiz) {
    this.quiz = quiz;
    return this;
  }

  public UUID getQuiz() {
    return quiz;
  }

  public QuizResult setUser(UUID user) {
    this.user = user;
    return this;
  }

  public UUID getUser() {
    return user;
  }
}
