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

  /** Instantiates new empty Account. */
  public Account() {}

  /**
   * Instantiates new Account.
   *
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
   * Sets value for ID.
   *
   * @param id New ID of user
   * @return object with new ID
   */
  public Account setId(UUID id) {
    this.id = id;
    return this;
  }

  /**
   * Returns ID.
   *
   * @return ID of user
   */
  public UUID getId() {
    return id;
  }

  /**
   * Sets value for username.
   *
   * @param email New email of user
   * @return object with new email
   */
  public Account setEmail(String email) {
    this.email = email;
    return this;
  }

  /**
   * Returns username.
   *
   * @return username of user
   */
  public String getEmail() {
    return email;
  }

  /**
   * Sets value for hash of password.
   *
   * @param passwordHash New hash of password
   * @return object with new hash of password
   */
  public Account setPasswordHash(String passwordHash) {
    this.passwordHash = passwordHash;
    return this;
  }

  /**
   * Returns hash of password.
   *
   * @return hash of password of user
   */
  public String getPasswordHash() {
    return passwordHash;
  }

  /**
   * Updates last date of login.
   *
   * @param lastActiveDate New login date
   * @return object with new login date
   */
  public Account setLastActiveDate(Integer lastActiveDate) {
    this.lastActiveDate = lastActiveDate;
    return this;
  }

  /**
   * Returns last login date.
   *
   * @return last login date of user
   */
  public Integer getLastActiveDate() {
    return lastActiveDate;
  }

  /**
   * Returns user.
   *
   * @return associated user
   */
  public User getUser() {
    return user;
  }

  /**
   * Sets user.
   *
   * @param user associated user
   * @return object with new user
   */
  public Account setUser(User user) {
    this.user = user;
    return this;
  }

  /**
   * Returns invite code.
   *
   * @return invite code of user
   */
  public InviteCode getInviteCodes() {
    return inviteCode;
  }

  /**
   * Sets invite code.
   *
   * @param inviteCode new invite code of user
   * @return object with new invite code
   */
  public Account setInviteCodes(InviteCode inviteCode) {
    this.inviteCode = inviteCode;
    return this;
  }
}
