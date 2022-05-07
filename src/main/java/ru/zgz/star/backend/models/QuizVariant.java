package ru.zgz.star.backend.models;

import io.ebean.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;
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
public class QuizVariant extends Model {
  @Id
  @GeneratedValue(generator = "UUID")
  
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
