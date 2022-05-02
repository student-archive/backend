package ru.zgz.star.backend.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;

/**
 * Model for table <code>quiz_history</code>.
 *
 * <p>Storing history of quizzes walkthroughs
 *
 * @author ironalex
 */
@Entity
@Table(name = "quiz_history")
public class QuizHistory {
  @Id
  @GeneratedValue(generator = "UUID")
  @GenericGenerator(name = "uuid", strategy = "uuid2")
  @Column(name = "id")
  private UUID id;

  @ManyToOne
  @JoinColumn(name = "question_id")
  private Question question;

  @ManyToOne
  @JoinColumn(name = "selected_variant_id")
  private QuizVariant selectedVariant;

  @ManyToOne
  @JoinColumn(name = "user_id")
  private User user;

  public QuizHistory() {}

  public QuizHistory(Question question, QuizVariant selectedVariant, User user) {
    this.question = question;
    this.selectedVariant = selectedVariant;
    this.user = user;
  }

  public QuizHistory setId(UUID id) {
    this.id = id;
    return this;
  }

  public UUID getId() {
    return id;
  }

  public QuizHistory setQuestion(Question question) {
    this.question = question;
    return this;
  }

  public Question getQuestion() {
    return question;
  }

  public QuizHistory setSelectedVariant(QuizVariant selectedVariant) {
    this.selectedVariant = selectedVariant;
    return this;
  }

  public QuizVariant getSelectedVariant() {
    return selectedVariant;
  }

  public QuizHistory setUser(User user) {
    this.user = user;
    return this;
  }

  public User getUser() {
    return user;
  }
}
