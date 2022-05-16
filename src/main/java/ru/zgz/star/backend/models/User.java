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
  private UUID role;
  private UUID account;
  private UUID group;
  private Short sex;

  public User() {}

  public User(
      String firstName,
      String lastName,
      String avatarLink,
      Short sex,
      UUID role,
      UUID account,
      UUID group) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.avatarLink = avatarLink;
    this.sex = sex;
    this.role = role;
    this.account = account;
    this.group = group;
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

  public User setRole(UUID role) {
    this.role = role;
    return this;
  }

  public UUID getRole() {
    return role;
  }

  public String getAvatarLink() {
    return avatarLink;
  }

  public User setAvatarLink(String avatarLink) {
    this.avatarLink = avatarLink;
    return this;
  }

  public UUID getAccount() {
    return account;
  }

  public User setAccount(UUID account) {
    this.account = account;
    return this;
  }

  public UUID getGroup() {
    return group;
  }

  public User setGroup(UUID group) {
    this.group = group;
    return this;
  }

  public Short getSex() {
    return sex;
  }

  public User setSex(short sex) {
    this.sex = sex;
    return this;
  }
}
