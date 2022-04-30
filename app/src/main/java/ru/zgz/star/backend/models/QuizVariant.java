package ru.zgz.star.backend.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.UUID;

/**
 * Model for table <code>quiz_variant</code>.
 *
 * <p>Storing variants for questions
 *
 * @author ironalex
 */
@Entity
@Table(name = "quiz_variant")
public class QuizVariant {
  private UUID id;
  private String quizVariantText;
  private Boolean isCorrect;

  public void setId(UUID id) {
    this.id = id;
  }

  @Id
  @GeneratedValue
  public UUID getId() {
    return id;
  }

  public void setQuizVariantText(String quizVariantText) {
    this.quizVariantText = quizVariantText;
  }

  public String getQuizVariantText() {
    return quizVariantText;
  }

  public void setCorrect(Boolean correct) {
    isCorrect = correct;
  }

  public Boolean getCorrect() {
    return isCorrect;
  }
}
