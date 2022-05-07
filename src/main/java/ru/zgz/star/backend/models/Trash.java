package ru.zgz.star.backend.models;

import java.util.UUID;

/**
 * Model for table <code>trash</code>.
 *
 * <p>Storing deleted elements
 *
 * @author ironalex
 */
public class Trash {
  private UUID id;
  private UUID deletedId;
  private Integer deletingDate;
  private Group group;

  /** Instantiates a new Trash. */
  public Trash() {}

  /**
   * Instantiates a new Trash.
   *
   * @param deletedId the deleted id
   * @param deletingDate the deleting date
   * @param group the group
   */
  public Trash(UUID deletedId, Integer deletingDate, Group group) {
    this.deletedId = deletedId;
    this.deletingDate = deletingDate;
    this.group = group;
  }

  /**
   * Sets id.
   *
   * @param id the id
   * @return the id
   */
  public Trash setId(UUID id) {
    this.id = id;
    return this;
  }

  /**
   * Gets id.
   *
   * @return the id
   */
  public UUID getId() {
    return id;
  }

  /**
   * Sets deleted id.
   *
   * @param deletedId the deleted id
   * @return the deleted id
   */
  public Trash setDeletedId(UUID deletedId) {
    this.deletedId = deletedId;
    return this;
  }

  /**
   * Gets deleted id.
   *
   * @return the deleted id
   */
  public UUID getDeletedId() {
    return deletedId;
  }

  /**
   * Sets deleting date.
   *
   * @param deletingDate the deleting date
   * @return the deleting date
   */
  public Trash setDeletingDate(Integer deletingDate) {
    this.deletingDate = deletingDate;
    return this;
  }

  /**
   * Gets deleting date.
   *
   * @return the deleting date
   */
  public Integer getDeletingDate() {
    return deletingDate;
  }

  /**
   * Sets group.
   *
   * @param group the group
   * @return the group
   */
  public Trash setGroup(Group group) {
    this.group = group;
    return this;
  }

  /**
   * Gets group.
   *
   * @return the group
   */
  public Group getGroup() {
    return group;
  }
}
