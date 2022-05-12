package ru.zgz.star.backend.responses;

import java.util.UUID;

/** Model, representing response sent, when deleting request was received. */
public class DeletedResponse {
  /** UUID of deleted resource. */
  public UUID deletedId;

  /**
   * Instantiates a new Deleted response.
   *
   * @param deletedId UUID of deleted resource.
   */
  public DeletedResponse(UUID deletedId) {
    this.deletedId = deletedId;
  }
}
