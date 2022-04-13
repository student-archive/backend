package ru.zgz.star.backend.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.Instant;
import java.util.UUID;

/**
 * Model for table <code>account</code>.
 *
 * <p>Storing authentication information about user
 *
 * @author dadyarri
 */
@Entity
@Table(name = "account")
public class Account {

  private UUID id;
  private String username;
  private String passwordHash;
  private Instant lastLoginDate;

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
  @Id
  @GeneratedValue
  public UUID getId() {
    return id;
  }

  /**
   * Sets value for username
   *
   * @param username New ID of user
   */
  public Account setUsername(String username) {
    this.username = username;
    return this;
  }

  /**
   * Returns username
   *
   * @return username of user
   */
  public String getUsername() {
    return username;
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
   * @param lastLoginDate New login date
   */
  public Account setLastLoginDate(Instant lastLoginDate) {
    this.lastLoginDate = lastLoginDate;
    return this;
  }

  /**
   * Returns last login date
   *
   * @return last login date of user
   */
  public Instant getLastLoginDate() {
    return lastLoginDate;
  }
}
