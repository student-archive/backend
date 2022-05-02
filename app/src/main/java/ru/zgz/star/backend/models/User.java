package ru.zgz.star.backend.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.util.Set;
import java.util.UUID;
import org.hibernate.annotations.GenericGenerator;

/**
 * Model for table <code>user</code>.
 *
 * <p>Storing users
 *
 * @author dadyarri
 */
@Entity
@Table(name = "user")
public class User {
  @Id
  @GeneratedValue(generator = "UUID")
  @GenericGenerator(name = "uuid", strategy = "uuid2")
  @Column(name = "id")
  private UUID id;

  @Column(name = "first_name")
  private String firstName;

  @Column(name = "last_name")
  private String lastName;

  @Column(name = "avatar_link")
  private String avatarLink;

  @ManyToOne
  @JoinColumn(name = "role_id", nullable = false)
  private Role role;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "account_id")
  private Account account;

  @ManyToOne
  @JoinColumn(name = "group_id", nullable = false)
  private Group group;

  @ManyToOne
  @JoinColumn(name = "sex_id", nullable = false)
  private Sex sex;

  @OneToMany(mappedBy = "user")
  private Set<Event> events;

  @OneToMany(mappedBy = "user")
  private Set<QuizHistory> quizHistories;

  @OneToMany(mappedBy = "user")
  private Set<QuizResult> quizResults;

  @OneToMany(mappedBy = "user")
  private Set<Event> event;

  public User() {}

  public User(String firstName, String lastName, String avatarLink) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.avatarLink = avatarLink;
  }

  public User setId(UUID id) {
    this.id = id;
    return this;
  }

  public UUID getId() {
    return id;
  }

  public User setFirstName(String firstName) {
    this.firstName = firstName;
    return this;
  }

  public String getFirstName() {
    return firstName;
  }

  public User setLastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

  public String getLastName() {
    return lastName;
  }

  public User setRole(Role role) {
    this.role = role;
    return this;
  }

  public Role getRole() {
    return role;
  }

  public String getAvatarLink() {
    return avatarLink;
  }

  public User setAvatarLink(String avatarLink) {
    this.avatarLink = avatarLink;
    return this;
  }

  public Account getAccount() {
    return account;
  }

  public User setAccount(Account account) {
    this.account = account;
    return this;
  }

  public Group getGroup() {
    return group;
  }

  public User setGroup(Group group) {
    this.group = group;
    return this;
  }

  public Sex getSex() {
    return sex;
  }

  public User setSex(Sex sex) {
    this.sex = sex;
    return this;
  }

  public Set<Event> getEvents() {
    return events;
  }

  public User setEvents(Set<Event> events) {
    this.events = events;
    return this;
  }

  public Set<QuizHistory> getQuizHistories() {
    return quizHistories;
  }

  public User setQuizHistories(Set<QuizHistory> quizHistories) {
    this.quizHistories = quizHistories;
    return this;
  }

  public Set<Event> getEvent() {
    return event;
  }

  public void setEvent(Set<Event> event) {
    this.event = event;
  }

  public Set<QuizResult> getQuizResults() {
    return quizResults;
  }

  public void setQuizResults(Set<QuizResult> quizResults) {
    this.quizResults = quizResults;
  }
}
