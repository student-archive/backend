package ru.zgz.star.backend.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.Set;
import java.util.UUID;
import org.hibernate.annotations.GenericGenerator;

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

  @OneToMany(mappedBy = "type")
  private Set<Attachment> attachment;

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

  public Set<Attachment> getAttachment() {
    return attachment;
  }

  public AttachmentType setAttachment(Set<Attachment> attachment) {
    this.attachment = attachment;
    return this;
  }
}
