package ru.zgz.star.backend.models;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

/**
 * Model for table <code>page</code>.
 *
 * <p>Storing attachments
 *
 * @author ironalex
 */
@Entity
@Table(name = "page")
public class Page {
  private UUID id;
  private String link;

  @ManyToOne private Subject subject;
  @ManyToMany private Set<Attachment> attachment;

  public void setId(UUID id) {
    this.id = id;
  }

  @Id
  @GeneratedValue
  public UUID getId() {
    return id;
  }

  public void setLink(String link) {
    this.link = link;
  }

  public String getLink() {
    return link;
  }

  public void setSubject(Subject subject) {
    this.subject = subject;
  }

  public Subject getSubject() {
    return subject;
  }

  public void setAttachment(Set<Attachment> attachment) {
    this.attachment = attachment;
  }

  public Set<Attachment> getAttachment() {
    return attachment;
  }
}
