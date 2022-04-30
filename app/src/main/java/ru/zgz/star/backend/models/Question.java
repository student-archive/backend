package ru.zgz.star.backend.models;

import jakarta.persistence.*;
import java.util.Set;
import java.util.UUID;

/**
 * Model for table <code>question</code>.
 *
 * <p>Storing information about question of quiz
 *
 * @author ironalex
 */
@Entity
@Table(name = "question")
public class Question {
  private UUID id;
  private String questionText;
  @OneToMany private Set<QuizVariant> variants;

  /**
   * Sets value for ID
   *
   * @param id New ID of question
   */
  public void setId(UUID id) {
    this.id = id;
  }

  /**
   * Returns ID
   *
   * @return ID of question
   */
  @Id
  @GeneratedValue
  public UUID getId() {
    return id;
  }

  /**
   * Sets value for question text
   *
   * @param questionText New text of question
   */
  public void setQuestionText(String questionText) {
    this.questionText = questionText;
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
  public void setVariants(Set<QuizVariant> variants) {
    this.variants = variants;
  }

  /**
   * Returns variants of question
   *
   * @return variants of question
   */
  public Set<QuizVariant> getVariants() {
    return variants;
  }
}
