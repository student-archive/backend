package ru.zgz.star.backend.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.util.Set;
import java.util.UUID;
import org.hibernate.annotations.GenericGenerator;

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
  private Integer lastActiveDate;

  @OneToMany(mappedBy = "account", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
  private Set<InviteCode> inviteCodes;

  @OneToOne(
      mappedBy = "account",
      optional = false,
      cascade = CascadeType.ALL,
      fetch = FetchType.EAGER)
  private User user;

  public Account() {}

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

  public Set<InviteCode> getInviteCodes() {
    return inviteCodes;
  }

  public Account setInviteCodes(Set<InviteCode> inviteCodes) {
    this.inviteCodes = inviteCodes;
    return this;
  }
}
