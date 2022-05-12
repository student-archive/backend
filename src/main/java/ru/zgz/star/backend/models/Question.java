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
  private UUID quiz;


  public Question() {}

  public Question(String questionText, UUID quiz) {
    this.questionText = questionText;
    this.quiz = quiz;
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




  public UUID getQuiz() {
    return quiz;
  }

  public Question setQuiz(UUID quiz) {
    this.quiz = quiz;
    return this;
  }



}
