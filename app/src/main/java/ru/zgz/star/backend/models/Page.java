package ru.zgz.star.backend.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

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
  @Id
  @GeneratedValue(generator = "UUID")
  @GenericGenerator(name = "uuid", strategy = "uuid2")
  @Column(name = "id")
  private UUID id;

  @Column(name = "link")
  private String link;

  @ManyToOne private Subject subject;
  @ManyToMany private Set<Attachment> attachment;

  public Page() {}

  public Page(String link, Subject subject, Set<Attachment> attachment) {
    this.link = link;
    this.subject = subject;
    this.attachment = attachment;
  }

  public Page setId(UUID id) {
    this.id = id;
    return this;
  }

  public UUID getId() {
    return id;
  }

  public Page setLink(String link) {
    this.link = link;
    return this;
  }

  public String getLink() {
    return link;
  }

  public Page setSubject(Subject subject) {
    this.subject = subject;
    return this;
  }

  public Subject getSubject() {
    return subject;
  }

  public Page setAttachment(Set<Attachment> attachment) {
    this.attachment = attachment;
    return this;
  }

  public Set<Attachment> getAttachment() {
    return attachment;
  }
}
