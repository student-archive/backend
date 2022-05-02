package ru.zgz.star.backend.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
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
  private boolean isValid;

  @Column(name = "activated_date")
  private int activationDate;

  @ManyToOne private Account account;

  public InviteCode() {}

  public InviteCode(String inviteCode, boolean isValid, int activationDate, Account account) {
    this.inviteCode = inviteCode;
    this.isValid = isValid;
    this.activationDate = activationDate;
    this.account = account;
  }

  public UUID getId() {
    return id;
  }

  public InviteCode setId(UUID id) {
    this.id = id;
    return this;
  }

  public Account getAccount() {
    return account;
  }

  public InviteCode setAccount(Account account) {
    this.account = account;
    return this;
  }

  public String getInviteCode() {
    return inviteCode;
  }

  public InviteCode setInviteCode(String inviteCode) {
    this.inviteCode = inviteCode;
    return this;
  }

  public boolean getIsValid() {
    return isValid;
  }

  public InviteCode setIsValid(boolean isValid) {
    this.isValid = isValid;
    return this;
  }

  public int getActivationDate() {
    return activationDate;
  }

  public InviteCode setActivationDate(int activationDate) {
    this.activationDate = activationDate;
    return this;
  }
}
