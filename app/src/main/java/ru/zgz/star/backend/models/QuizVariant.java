package ru.zgz.star.backend.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "quizVariant")
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
