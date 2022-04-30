package ru.zgz.star.backend.models;

import jakarta.persistence.*;
import java.time.Instant;
import java.util.UUID;

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
  private UUID id;

  @ManyToOne private Account account;
  private String inviteCode;
  private boolean isValid;
  private Instant activationDate;

  @Id
  @GeneratedValue
  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public Account getAccount() {
    return account;
  }

  public void setAccount(Account account) {
    this.account = account;
  }

  public String getInviteCode() {
    return inviteCode;
  }

  public void setInviteCode(String inviteCode) {
    this.inviteCode = inviteCode;
  }

  public boolean getIsValid() {
    return isValid;
  }

  public void setIsValid(boolean isValid) {
    this.isValid = isValid;
  }

  public Instant getActivationDate() {
    return activationDate;
  }

  public void setActivationDate(Instant activationDate) {
    this.activationDate = activationDate;
  }
}
