package ru.zgz.star.backend.models;

import java.util.List;
import java.util.UUID;

/**
 * Model for table <code>attachment</code>.
 *
 * <p>Storing attachments
 *
 * @author ironalex
 */
public class Attachment {
  private UUID id;
  private String link;
  private String author;
  private String checksum;
  private AttachmentType type;
  private List<Page> page;

  public Attachment() {}

  /**
   * Creates new attachment.
   *
   * @param link link of attachment
   * @param author author of attachment
   * @param checksum checksum of file
   * @param type type of attachment
   * @param page pages of attachment
   */
  public Attachment(
      String link, String author, String checksum, AttachmentType type, List<Page> page) {
    this.link = link;
    this.author = author;
    this.checksum = checksum;
    this.type = type;
    this.page = page;
  }

  /**
   * Sets value for ID
   *
   * @param id New ID of attachment
   */
  public Attachment setId(UUID id) {
    this.id = id;
    return this;
  }

  /**
   * Returns ID
   *
   * @return ID of attachment
   */
  public UUID getId() {
    return id;
  }

  /**
   * Sets value for link
   *
   * @param link New link of attachment
   */
  public Attachment setLink(String link) {
    this.link = link;
    return this;
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
  public Attachment setAuthor(String author) {
    this.author = author;
    return this;
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
  public Attachment setChecksum(String checksum) {
    this.checksum = checksum;
    return this;
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
  public Attachment setType(AttachmentType type) {
    this.type = type;
    return this;
  }

  /**
   * Returns type
   *
   * @return Type of attachment
   */
  public AttachmentType getType() {
    return type;
  }

  public Attachment setPage(List<Page> page) {
    this.page = page;
    return this;
  }

  /**
   * Returns page
   *
   * @return Pages of attachment
   */
  public List<Page> getPage() {
    return page;
  }
}
