package ru.zgz.star.backend.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
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

  @ManyToOne private Group group;

  public Trash() {}

  public Trash(UUID deletedId, int deletingDate, Group group) {
    this.deletedId = deletedId;
    this.deletingDate = deletingDate;
    this.group = group;
  }

  public Trash setId(UUID id) {
    this.id = id;
    return this;
  }

  public UUID getId() {
    return id;
  }

  public Trash setDeletedId(UUID deletedId) {
    this.deletedId = deletedId;
    return this;
  }

  public UUID getDeletedId() {
    return deletedId;
  }

  public Trash setDeletingDate(int deletingDate) {
    this.deletingDate = deletingDate;
    return this;
  }

  public int getDeletingDate() {
    return deletingDate;
  }

  public Trash setGroup(Group group) {
    this.group = group;
    return this;
  }

  public Group getGroup() {
    return group;
  }
}
