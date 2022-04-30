package ru.zgz.star.backend.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;

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

  @ManyToOne private Role role;
  @OneToOne private Account account;
  @ManyToOne private Group group;
  @ManyToOne private Sex sex;

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
}
