package ru.zgz.star.backend.models;

import java.util.UUID;

/**
 * Model for table <code>invite_code</code>.
 *
 * <p>Storing invite codes
 *
 * @author dadyarri
 */
public class InviteCode {

  private UUID id;
  private String inviteCode;
  private Boolean isValid;
  private Integer activationDate;
  private UUID account;

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
  public InviteCode(String inviteCode, Boolean isValid, Integer activationDate, UUID account) {
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
  public UUID getAccount() {
    return account;
  }

  /**
   * Sets account.
   *
   * @param account the account
   * @return the account
   */
  public InviteCode setAccount(UUID account) {
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
