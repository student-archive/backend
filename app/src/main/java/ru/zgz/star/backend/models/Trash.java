package ru.zgz.star.backend.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.time.Instant;
import java.util.UUID;

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
  private UUID id;
  private UUID deletedId;
  private Instant deletingDate;

  @ManyToOne private Group group;

  public void setId(UUID id) {
    this.id = id;
  }

  @Id
  @GeneratedValue
  public UUID getId() {
    return id;
  }

  public void setDeletedId(UUID deletedId) {
    this.deletedId = deletedId;
  }

  public UUID getDeletedId() {
    return deletedId;
  }

  public void setDeletingDate(Instant deletingDate) {
    this.deletingDate = deletingDate;
  }

  public Instant getDeletingDate() {
    return deletingDate;
  }

  public void setGroup(Group group) {
    this.group = group;
  }

  public Group getGroup() {
    return group;
  }
}
