package ru.giv.star.api.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.UUID;

@Entity
class InviteCode {
  private @Id @GeneratedValue UUID id;
  private String inviteCode;
  private Boolean isValid;
  private Timestamp activatedDate;

  public InviteCode() {}

  InviteCode(String inviteCode, Boolean isValid, Timestamp activatedDate) {
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

  public Timestamp getActivatedDate() {
    return activatedDate;
  }
}
