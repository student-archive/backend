package ru.giv.star.api.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.Instant;
import java.util.UUID;

@Entity
class InviteCode {
  private @Id @GeneratedValue UUID id;
  private String inviteCode;
  private Boolean isValid;
  private Instant activatedDate;

  public InviteCode() {}

  InviteCode(String inviteCode, Boolean isValid, Instant activatedDate) {
    this.inviteCode = inviteCode;
    this.isValid = isValid;
    this.activatedDate = activatedDate;
  }

  public UUID getId() {
    return this.id;
  }

  public String getInviteCode() {
    return inviteCode;
  }

  public Boolean getValid() {
    return isValid;
  }

  public Instant getActivatedDate() {
    return activatedDate;
  }
}
