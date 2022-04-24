package ru.zgz.star.backend.models;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

/**
 * Model for table <code>attachment</code>.
 *
 * <p>Storing attachments
 *
 * @author ironalex
 */
@Entity
@Table(name = "attachment")
public class Attachment {
  private UUID id;
  private String link;
  private String author;
  private String checksum;

  @ManyToOne private AttachmentType type;
  @ManyToMany private Set<Page> page;

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

  public void setAuthor(String author) {
    this.author = author;
  }

  public String getAuthor() {
    return author;
  }

  public void setChecksum(String checksum) {
    this.checksum = checksum;
  }

  public String getChecksum() {
    return checksum;
  }

  public void setType(AttachmentType type) {
    this.type = type;
  }

  public AttachmentType getType() {
    return type;
  }

  public void setPage(Set<Page> page) {
    this.page = page;
  }

  public Set<Page> getPage() {
    return page;
  }
}
