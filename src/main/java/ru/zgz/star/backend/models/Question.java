package ru.zgz.star.backend.models;

import java.util.List;
import java.util.UUID;

/**
 * Model for table <code>question</code>.
 *
 * <p>Storing information about question of quiz
 *
 * @author ironalex
 */

public class Question {

  private UUID id;
  private String questionText;
  private Quiz quiz;
  private List<QuizVariant> variants;
  private List<QuizHistory> quizHistories;

  public Question() {}

  public Question(String questionText, List<QuizVariant> variants) {
    this.questionText = questionText;
    this.variants = variants;
  }

  /**
   * Sets value for ID
   *
   * @param id New ID of question
   */
  public Question setId(UUID id) {
    this.id = id;
    return this;
  }

  /**
   * Returns ID
   *
   * @return ID of question
   */
  public UUID getId() {
    return id;
  }

  /**
   * Sets value for question text
   *
   * @param questionText New text of question
   */
  public Question setQuestionText(String questionText) {
    this.questionText = questionText;
    return this;
  }

  /**
   * Returns text of question
   *
   * @return text of question
   */
  public String getQuestionText() {
    return questionText;
  }

  /**
   * Sets value for variants of question
   *
   * @param variants New set of variants
   */
  public Question setVariants(List<QuizVariant> variants) {
    this.variants = variants;
    return this;
  }

  /**
   * Returns variants of question
   *
   * @return variants of question
   */
  public List<QuizVariant> getVariants() {
    return variants;
  }

  public Quiz getQuiz() {
    return quiz;
  }

  public Question setQuiz(Quiz quiz) {
    this.quiz = quiz;
    return this;
  }

  public List<QuizHistory> getQuizHistories() {
    return quizHistories;
  }

  public Question setQuizHistories(List<QuizHistory> quizHistories) {
    this.quizHistories = quizHistories;
    return this;
  }
}
