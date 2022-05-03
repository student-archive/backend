package ru.zgz.star.backend.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.util.UUID;
import org.hibernate.annotations.GenericGenerator;

/**
 * Model for table <code>invite_code</code>.
 *
 * <p>Storing invite codes
 *
 * @author dadyarri
 */
@Entity
@Table(name = "invite_code")
public class InviteCode {
  @Id
  @GeneratedValue(generator = "UUID")
  @GenericGenerator(name = "uuid", strategy = "uuid2")
  @Column(name = "id")
  private UUID id;

  @Column(name = "invite_code")
  private String inviteCode;

  @Column(name = "is_valid")
  private Boolean isValid;

  @Column(name = "activated_date")
  private Integer activationDate;

  @OneToOne(optional = false)
  private Account account;

  /** Instantiates a new Invite code. */
  public InviteCode() {}

  /**
   * Instantiates a new Invite code.
   *
   * @param inviteCode the invite code
   * @param isValid the is valid
   * @param activationDate the activation date
   * @param account the account
   */
  public InviteCode(String inviteCode, Boolean isValid, Integer activationDate, Account account) {
    this.inviteCode = inviteCode;
    this.isValid = isValid;
    this.activationDate = activationDate;
    this.account = account;
  }

  /**
   * Gets id.
   *
   * @return the id
   */
  public UUID getId() {
    return id;
  }

  /**
   * Sets id.
   *
   * @param id the id
   * @return the id
   */
  public InviteCode setId(UUID id) {
    this.id = id;
    return this;
  }

  /**
   * Gets account.
   *
   * @return the account
   */
  public Account getAccount() {
    return account;
  }

  /**
   * Sets account.
   *
   * @param account the account
   * @return the account
   */
  public InviteCode setAccount(Account account) {
    this.account = account;
    return this;
  }

  /**
   * Gets invite code.
   *
   * @return the invite code
   */
  public String getInviteCode() {
    return inviteCode;
  }

  /**
   * Sets invite code.
   *
   * @param inviteCode the invite code
   * @return the invite code
   */
  public InviteCode setInviteCode(String inviteCode) {
    this.inviteCode = inviteCode;
    return this;
  }

  /**
   * Gets is valid.
   *
   * @return the is valid
   */
  public Boolean getIsValid() {
    return isValid;
  }

  /**
   * Sets is valid.
   *
   * @param isValid the is valid
   * @return the is valid
   */
  public InviteCode setIsValid(Boolean isValid) {
    this.isValid = isValid;
    return this;
  }

  /**
   * Gets activation date.
   *
   * @return the activation date
   */
  public Integer getActivationDate() {
    return activationDate;
  }

  /**
   * Sets activation date.
   *
   * @param activationDate the activation date
   * @return the activation date
   */
  public InviteCode setActivationDate(Integer activationDate) {
    this.activationDate = activationDate;
    return this;
  }
}
