package ru.zgz.star.backend.models;

import io.ebean.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


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
public class QuizHistory extends Model {
  @Id
  @GeneratedValue(generator = "UUID")
  
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
