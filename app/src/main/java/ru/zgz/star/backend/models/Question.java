package ru.zgz.star.backend.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

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
  @Id
  @GeneratedValue(generator = "UUID")
  @GenericGenerator(name = "uuid", strategy = "uuid2")
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
