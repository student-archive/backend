package ru.zgz.star.backend.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.Set;
import java.util.UUID;
import org.hibernate.annotations.GenericGenerator;

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

  @ManyToOne
  @JoinColumn(name = "question_id", nullable = false)
  private Question question;

  @OneToMany(mappedBy = "selectedVariant")
  private Set<QuizHistory> quizHistories;

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

  public Set<QuizHistory> getQuizHistories() {
    return quizHistories;
  }

  public QuizVariant setQuizHistories(Set<QuizHistory> quizHistories) {
    this.quizHistories = quizHistories;
    return this;
  }
}
