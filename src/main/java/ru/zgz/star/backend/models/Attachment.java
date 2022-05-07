package ru.zgz.star.backend.models;

import io.ebean.Model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


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
public class Attachment extends Model {
  @Id
  @GeneratedValue(generator = "UUID")
  @Column(name = "id")
  private UUID id;

  @Column(name = "attachment_link")
  private String link;

  @Column(name = "author")
  private String author;

  @Column(name = "checksum")
  private String checksum;

  @ManyToOne
  @JoinColumn(name = "type_id", nullable = false)
  private AttachmentType type;

  @ManyToMany(cascade = CascadeType.ALL)
  @JoinTable(
      name = "page_attachment",
      joinColumns = @JoinColumn(name = "attachment_id"),
      inverseJoinColumns = @JoinColumn(name = "page_id"))
  private Set<Page> page;

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
      String link, String author, String checksum, AttachmentType type, Set<Page> page) {
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

  public Attachment setPage(Set<Page> page) {
    this.page = page;
    return this;
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