package ru.zgz.star.backend.models;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

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
  @Id
  @GeneratedValue(generator = "UUID")
  @GenericGenerator(name = "uuid", strategy = "uuid2")
  @Column(name = "id")
  private UUID id;

  @Column(name = "type_name")
  private String typeName;

  public AttachmentType() {}

  public AttachmentType(String typeName) {
    this.typeName = typeName;
  }

  public AttachmentType setId(UUID id) {
    this.id = id;
    return this;
  }

  public UUID getId() {
    return id;
  }

  public AttachmentType setTypeName(String typeName) {
    this.typeName = typeName;
    return this;
  }

  public String getTypeName() {
    return typeName;
  }
}
