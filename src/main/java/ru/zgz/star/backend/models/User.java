package ru.zgz.star.backend.models;

import java.util.UUID;

/**
 * Model for table <code>user</code>.
 *
 * <p>Storing users
 *
 * @author dadyarri
 */
public class User {
  private UUID id;
  private String firstName;
  private String lastName;
  private String avatarLink;
  private Role role;
  private Account account;
  private Group group;
  private Sex sex;

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
