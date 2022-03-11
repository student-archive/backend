package ru.giv.star.api.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.giv.star.api.models.InviteCode;
import ru.giv.star.api.repositories.InviteCodeRepository;
import ru.giv.star.api.requestBodies.PostInviteCodeBody;

@RestController
public class InviteCodeController {
  private final InviteCodeRepository repository;

  InviteCodeController(InviteCodeRepository repository) {
    this.repository = repository;
  }

  /**
   * Creates invite code
   *
   * @param body information about group and role
   * @return invite code representation in database
   */
  @PostMapping("/inviteCode")
  InviteCode generate(@RequestBody PostInviteCodeBody body) {
    return repository.save(new InviteCode(body));
  }
}
