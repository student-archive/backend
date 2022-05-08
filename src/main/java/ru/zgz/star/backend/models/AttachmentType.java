package ru.zgz.star.backend.models;

import java.util.List;
import java.util.UUID;


/**
 * Model for table <code>attachment_type</code>.
 *
 * <p>Storing types of attachments
 *
 * @author ironalex
 */

public class AttachmentType {
  private UUID id;
  private String typeName;
  private List<Attachment> attachment;

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

  public List<Attachment> getAttachment() {
    return attachment;
  }

  public AttachmentType setAttachment(List<Attachment> attachment) {
    this.attachment = attachment;
    return this;
  }
}
