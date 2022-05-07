package ru.zgz.star.backend.models;

import io.ebean.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;
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
public class AttachmentType extends Model {
  @Id
  @GeneratedValue(generator = "UUID")
  
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
