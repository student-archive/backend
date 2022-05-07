package ru.zgz.star.backend.models;

import java.util.List;
import java.util.UUID;

/**
 * Model for table <code>quiz</code>.
 *
 * <p>Storing quizzes
 *
 * @author ironalex
 */
public class Quiz {
  private UUID id;
  private String quizName;
  private String quizDescription;
  private Integer questionsAmount;
  private Subject subject;
  private List<Question> questions;
  private List<QuizResult> quizResults;

  public Quiz() {}

  public Quiz(
      String quizName,
      String quizDescription,
      Integer questionsAmount,
      Subject subject,
      List<Question> questions) {
    this.quizName = quizName;
    this.quizDescription = quizDescription;
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

  public Quiz setQuestions(List<Question> questions) {
    this.questions = questions;
    return this;
  }

  public List<Question> getQuestions() {
    return questions;
  }

  public List<QuizResult> getQuizResults() {
    return quizResults;
  }

  public Quiz setQuizResults(List<QuizResult> quizResults) {
    this.quizResults = quizResults;
    return this;
  }
}
