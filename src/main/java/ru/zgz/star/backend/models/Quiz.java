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
 * Model for table <code>quiz</code>.
 *
 * <p>Storing quizzes
 *
 * @author ironalex
 */
@Entity
@Table(name = "quiz")
public class Quiz extends Model {
  @Id
  @GeneratedValue(generator = "UUID")
  
  @Column(name = "id")
  private UUID id;

  @Column(name = "quiz_name")
  private String quizName;

  @Column(name = "quiz_description")
  private String quizDescription;

  @Column(name = "questions_amount")
  private Integer questionsAmount;

  @ManyToOne
  @JoinColumn(name = "subject_id")
  private Subject subject;

  @OneToMany(mappedBy = "quiz")
  private Set<Question> questions;

  @OneToMany(mappedBy = "quiz")
  private Set<QuizResult> quizResults;

  public Quiz() {}

  public Quiz(
      String quizName,
      String quizDescription,
      Integer questionsAmount,
      Subject subject,
      Set<Question> questions) {
    this.quizName = quizName;
    this.questionsAmount = questionsAmount;
    this.subject = subject;
    this.questions = questions;
  }

  public Quiz setId(UUID id) {
    this.id = id;
    return this;
  }

  public UUID getId() {
    return id;
  }

  public Quiz setQuizName(String quizName) {
    this.quizName = quizName;
    return this;
  }

  public String getQuizName() {
    return quizName;
  }

  public Quiz setQuizDescription(String quizDescription) {
    this.quizDescription = quizDescription;
    return this;
  }

  public String getQuizDescription() {
    return quizDescription;
  }

  public Quiz setQuestionsAmount(Integer amountOfQuestions) {
    this.questionsAmount = amountOfQuestions;
    return this;
  }

  public Integer getQuestionsAmount() {
    return questionsAmount;
  }

  public Quiz setSubject(Subject subject) {
    this.subject = subject;
    return this;
  }

  public Subject getSubject() {
    return subject;
  }

  public Quiz setQuestions(Set<Question> questions) {
    this.questions = questions;
    return this;
  }

  public Set<Question> getQuestions() {
    return questions;
  }

  public Set<QuizResult> getQuizResults() {
    return quizResults;
  }

  public Quiz setQuizResults(Set<QuizResult> quizResults) {
    this.quizResults = quizResults;
    return this;
  }
}
