package ru.zgz.star.backend.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.UUID;

/**
 * Model for table <code>attachment_type</code>.
 *
 * <p>Storing types of attachments
 *
 * @author ironalex
 */
@Entity
@Table(name = "attachment_type")
public class AttachmentType {
  private UUID id;
  private String typeName;

  public void setId(UUID id) {
    this.id = id;
  }

  @Id
  @GeneratedValue
  public UUID getId() {
    return id;
  }

  public void setTypeName(String typeName) {
    this.typeName = typeName;
  }

  public String getTypeName() {
    return typeName;
  }
}
