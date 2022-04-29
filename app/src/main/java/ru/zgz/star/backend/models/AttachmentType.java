package ru.zgz.star.backend.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
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
