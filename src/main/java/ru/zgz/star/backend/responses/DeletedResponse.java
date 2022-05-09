package ru.zgz.star.backend.responses;

import java.util.UUID;

public class DeletedResponse {
  public UUID deletedId;

  public DeletedResponse(UUID deletedId) {
    this.deletedId = deletedId;
  }
}
