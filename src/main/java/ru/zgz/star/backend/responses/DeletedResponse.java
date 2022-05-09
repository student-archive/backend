package ru.zgz.star.backend.responses;

import java.util.UUID;

/**
 * Model, representing response sent, when deleting request was received.
 */
public class DeletedResponse {
  public UUID deletedId;

  public DeletedResponse(UUID deletedId) {
    this.deletedId = deletedId;
  }
}
