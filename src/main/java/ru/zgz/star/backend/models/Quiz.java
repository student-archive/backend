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
  private UUID subject;

  public Quiz() {}

  public Quiz(String quizName, String quizDescription, Integer questionsAmount, UUID subject) {
    this.quizName = quizName;
    this.quizDescription = quizDescription;
    this.questionsAmount = questionsAmount;
    this.subject = subject;
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

  public Quiz setSubject(UUID subject) {
    this.subject = subject;
    return this;
  }

  public UUID getSubject() {
    return subject;
  }
}
