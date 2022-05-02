package ru.zgz.star.backend.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.util.UUID;
import org.hibernate.annotations.GenericGenerator;

/**
 * Model for table <code>trash</code>.
 *
 * <p>Storing deleted elements
 *
 * @author ironalex
 */
@Entity
@Table(name = "trash")
public class Trash {
  @Id
  @GeneratedValue(generator = "UUID")
  @GenericGenerator(name = "uuid", strategy = "uuid2")
  @Column(name = "id")
  private UUID id;

  @Column(name = "deleted_id")
  private UUID deletedId;

  @Column(name = "deleted_date")
  private int deletingDate;

  @ManyToOne
  @JoinColumn(name = "group_id")
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
  public Trash(UUID deletedId, int deletingDate, Group group) {
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
  public Trash setDeletingDate(int deletingDate) {
    this.deletingDate = deletingDate;
    return this;
  }

  /**
   * Gets deleting date.
   *
   * @return the deleting date
   */
  public int getDeletingDate() {
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
