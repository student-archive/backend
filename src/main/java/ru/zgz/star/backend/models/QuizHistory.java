package ru.zgz.star.backend.models;

import java.util.UUID;

/**
 * Model for table <code>quiz_history</code>.
 *
 * <p>Storing history of quizzes walkthroughs
 *
 * @author ironalex
 */
public class QuizHistory {

  private UUID id;
  private Question question;
  private QuizVariant selectedVariant;
  private User user;

  public QuizHistory() {}

  public QuizHistory(Question question, QuizVariant selectedVariant, User user) {
    this.question = question;
    this.selectedVariant = selectedVariant;
    this.user = user;
  }

  public QuizHistory setId(UUID id) {
    this.id = id;
    return this;
  }

  public UUID getId() {
    return id;
  }

  public QuizHistory setQuestion(Question question) {
    this.question = question;
    return this;
  }

  public Question getQuestion() {
    return question;
  }

  public QuizHistory setSelectedVariant(QuizVariant selectedVariant) {
    this.selectedVariant = selectedVariant;
    return this;
  }

  public QuizVariant getSelectedVariant() {
    return selectedVariant;
  }

  public QuizHistory setUser(User user) {
    this.user = user;
    return this;
  }

  public User getUser() {
    return user;
  }
}
