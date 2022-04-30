package ru.zgz.star.backend.models;

import jakarta.persistence.*;
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

  /**
   * Sets value for ID
   *
   * @param id New ID of attachment
   */
  public void setId(UUID id) {
    this.id = id;
  }

  /**
   * Returns ID
   *
   * @return ID of attachment
   */
  @Id
  @GeneratedValue
  public UUID getId() {
    return id;
  }

  /**
   * Sets value for link
   *
   * @param link New link of attachment
   */
  public void setLink(String link) {
    this.link = link;
  }

  /**
   * Returns link
   *
   * @return Link of attachment
   */
  public String getLink() {
    return link;
  }

  /**
   * Sets value for link
   *
   * @param author New author of attachment
   */
  public void setAuthor(String author) {
    this.author = author;
  }

  /**
   * Returns link
   *
   * @return Link of attachment
   */
  public String getAuthor() {
    return author;
  }

  /**
   * Sets value for checksum
   *
   * @param checksum New checksum of attachment
   */
  public void setChecksum(String checksum) {
    this.checksum = checksum;
  }

  /**
   * Returns checksum
   *
   * @return Checksum of attachment
   */
  public String getChecksum() {
    return checksum;
  }

  /**
   * Sets value for type
   *
   * @param type New type of attachment
   */
  public void setType(AttachmentType type) {
    this.type = type;
  }

  /**
   * Returns type
   *
   * @return Type of attachment
   */
  public AttachmentType getType() {
    return type;
  }

  public void setPage(Set<Page> page) {
    this.page = page;
  }

  /**
   * Returns page
   *
   * @return Pages of attachment
   */
  public Set<Page> getPage() {
    return page;
  }
}
