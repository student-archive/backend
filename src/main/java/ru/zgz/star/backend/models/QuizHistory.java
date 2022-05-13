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
  private UUID question;
  private UUID selectedVariant;
  private UUID user;

  public QuizHistory() {}

  public QuizHistory(UUID question, UUID selectedVariant, UUID user) {
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

  public QuizHistory setQuestion(UUID question) {
    this.question = question;
    return this;
  }

  public UUID getQuestion() {
    return question;
  }

  public QuizHistory setSelectedVariant(UUID selectedVariant) {
    this.selectedVariant = selectedVariant;
    return this;
  }

  public UUID getSelectedVariant() {
    return selectedVariant;
  }

  public QuizHistory setUser(UUID user) {
    this.user = user;
    return this;
  }

  public UUID getUser() {
    return user;
  }
}
