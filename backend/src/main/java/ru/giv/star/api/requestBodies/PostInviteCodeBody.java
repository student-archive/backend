package ru.giv.star.api.requestBodies;

import ru.giv.star.api.models.Role;

public class PostInviteCodeBody {
  private String groupName;
  private Role role;

  public String getGroupName() {
    return groupName;
  }

  public Role getRole() {
    return role;
  }
}
