package ru.zgz.star.backend.models;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

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
  @Id
  @GeneratedValue(generator = "UUID")
  @GenericGenerator(name = "uuid", strategy = "uuid2")
  @Column(name = "id")
  private UUID id;

  @Column(name = "quiz_variant_text")
  private String quizVariantText;

  @Column(name = "is_correct")
  private Boolean isCorrect;

  public QuizVariant() {}

  public QuizVariant(String quizVariantText,Boolean isCorrect) {
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
}
