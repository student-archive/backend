package ru.zgz.star.backend.models;

import javax.persistence.*;
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
  private UUID id;

  @ManyToOne private Question question;
  @ManyToOne private QuizVariant selectedVariant;
  @ManyToOne private User user;

  public void setId(UUID id) {
    this.id = id;
  }

  @Id
  @GeneratedValue
  public UUID getId() {
    return id;
  }

  public void setQuestion(Question question) {
    this.question = question;
  }

  public Question getQuestion() {
    return question;
  }

  public void setSelectedVariant(QuizVariant selectedVariant) {
    this.selectedVariant = selectedVariant;
  }

  public QuizVariant getSelectedVariant() {
    return selectedVariant;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public User getUser() {
    return user;
  }
}
