package ru.zgz.star.backend.models;

import java.util.UUID;

/**
 * Model for table <code>account</code>.
 *
 * <p>Storing authentication information about user
 *
 * @author dadyarri
 */
public class Account {
  private UUID id;
  private String email;
  private String passwordHash;
  private Integer lastActiveDate;
  private InviteCode inviteCode;
  private User user;

  public Account() {}

  /**
   * Instantiates new Account
   * @param email account's email
   * @param passwordHash account's hash of password
   * @param lastActiveDate account's last login date
   */
  public Account(String email, String passwordHash, Integer lastActiveDate) {
    this.email = email;
    this.passwordHash = passwordHash;
    this.lastActiveDate = lastActiveDate;
  }

  /**
   * Sets value for ID
   *
   * @param id New ID of user
   */
  public Account setId(UUID id) {
    this.id = id;
    return this;
  }

  /**
   * Returns ID
   *
   * @return ID of user
   */
  public UUID getId() {
    return id;
  }

  /**
   * Sets value for username
   *
   * @param email New ID of user
   */
  public Account setEmail(String email) {
    this.email = email;
    return this;
  }

  /**
   * Returns username
   *
   * @return username of user
   */
  public String getEmail() {
    return email;
  }

  /**
   * Sets value for hash of password
   *
   * @param passwordHash New hash of password
   */
  public Account setPasswordHash(String passwordHash) {
    this.passwordHash = passwordHash;
    return this;
  }

  /**
   * Returns hash of password
   *
   * @return hash of password of user
   */
  public String getPasswordHash() {
    return passwordHash;
  }

  /**
   * Updates last date of login
   *
   * @param lastActiveDate New login date
   */
  public Account setLastActiveDate(Integer lastActiveDate) {
    this.lastActiveDate = lastActiveDate;
    return this;
  }

  /**
   * Returns last login date
   *
   * @return last login date of user
   */
  public Integer getLastActiveDate() {
    return lastActiveDate;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public InviteCode getInviteCodes() {
    return inviteCode;
  }

  public Account setInviteCodes(InviteCode inviteCode) {
    this.inviteCode = inviteCode;
    return this;
  }
}
