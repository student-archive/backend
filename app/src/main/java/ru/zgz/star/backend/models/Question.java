package ru.zgz.star.backend.models;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "question")
public class Question {
  private UUID id;
  private String questionText;
  @OneToMany private Set<QuizVariant> variants;

  public void setId(UUID id) {
    this.id = id;
  }

  @Id
  @GeneratedValue
  public UUID getId() {
    return id;
  }

  public void setQuestionText(String questionText) {
    this.questionText = questionText;
  }

  public String getQuestionText() {
    return questionText;
  }

  public void setVariants(Set<QuizVariant> variants) {
    this.variants = variants;
  }

  public Set<QuizVariant> getVariants() {
    return variants;
  }
}

