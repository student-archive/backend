package ru.zgz.star.backend.models;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

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

  @Id
  @GeneratedValue(generator = "UUID")
  @GenericGenerator(name = "uuid", strategy = "uuid2")
  @Column(name = "id")
  private UUID id;

  @Column(name = "email")
  private String email;

  @Column(name = "password_hash")
  private String passwordHash;

  @Column(name = "last_active_date")
  private Instant lastActiveDate;

  public Account() {}

  public Account(UUID id, String email, String passwordHash, Instant lastActiveDate) {
    this.id = id;
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
  public Account setLastActiveDate(Instant lastActiveDate) {
    this.lastActiveDate = lastActiveDate;
    return this;
  }

  /**
   * Returns last login date
   *
   * @return last login date of user
   */
  public Instant getLastActiveDate() {
    return lastActiveDate;
  }
}
