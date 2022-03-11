package ru.giv.star.api.models;

import ru.giv.star.api.requestBodies.PostInviteCodeBody;
import ru.giv.star.api.utils.Utils;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.Instant;
import java.util.UUID;

@Entity
public class InviteCode {
  private @Id UUID id;
  private String inviteCode;
  private Boolean isValid;
  private Instant activatedDate;

  /**
   * Creates new InviteCode entity
   *
   * @param body information about group and role to generate a code
   */
  public InviteCode(PostInviteCodeBody body) {
    this.id = UUID.randomUUID();
    this.inviteCode = Utils.generateInviteCode(body.getGroupName(), body.getRole().getRoleName());
    this.isValid = true;
    this.activatedDate = Instant.now();
  }

  public InviteCode() {}

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
