package ru.zgz.star.backend.models;

import java.util.List;
import java.util.UUID;

/**
 * Model for table <code>quiz_variant</code>.
 *
 * <p>Storing variants for questions
 *
 * @author ironalex
 */
public class QuizVariant {

  private UUID id;
  private String quizVariantText;
  private Boolean isCorrect;
  private Question question;
  private List<QuizHistory> quizHistories;

  public QuizVariant() {}

  public QuizVariant(String quizVariantText, Boolean isCorrect) {
    this.quizVariantText = quizVariantText;
    this.isCorrect = isCorrect;
  }

  public QuizVariant setId(UUID id) {
    this.id = id;
    return this;
  }

  public UUID getId() {
    return id;
  }

  public QuizVariant setQuizVariantText(String quizVariantText) {
    this.quizVariantText = quizVariantText;
    return this;
  }

  public String getQuizVariantText() {
    return quizVariantText;
  }

  public QuizVariant setCorrect(Boolean correct) {
    isCorrect = correct;
    return this;
  }

  public Boolean getCorrect() {
    return isCorrect;
  }

  public Question getQuestion() {
    return question;
  }

  public QuizVariant setQuestion(Question question) {
    this.question = question;
    return this;
  }

  public List<QuizHistory> getQuizHistories() {
    return quizHistories;
  }

  public QuizVariant setQuizHistories(List<QuizHistory> quizHistories) {
    this.quizHistories = quizHistories;
    return this;
  }
}
