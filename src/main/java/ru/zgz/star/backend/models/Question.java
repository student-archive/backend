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
 * Model for table <code>question</code>.
 *
 * <p>Storing information about question of quiz
 *
 * @author ironalex
 */
@Entity
@Table(name = "question")
public class Question extends Model {
  @Id
  @GeneratedValue(generator = "UUID")
  
  @Column(name = "id")
  private UUID id;

  @Column(name = "question_text")
  private String questionText;

  @ManyToOne
  @JoinColumn(name = "quiz_id")
  private Quiz quiz;

  @OneToMany(mappedBy = "question")
  private Set<QuizVariant> variants;

  @OneToMany(mappedBy = "question")
  private Set<QuizHistory> quizHistories;

  public Question() {}

  public Question(String questionText, Set<QuizVariant> variants) {
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
  public Question setVariants(Set<QuizVariant> variants) {
    this.variants = variants;
    return this;
  }

  /**
   * Returns variants of question
   *
   * @return variants of question
   */
  public Set<QuizVariant> getVariants() {
    return variants;
  }

  public Quiz getQuiz() {
    return quiz;
  }

  public Question setQuiz(Quiz quiz) {
    this.quiz = quiz;
    return this;
  }

  public Set<QuizHistory> getQuizHistories() {
    return quizHistories;
  }

  public Question setQuizHistories(Set<QuizHistory> quizHistories) {
    this.quizHistories = quizHistories;
    return this;
  }
}
