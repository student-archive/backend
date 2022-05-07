package ru.zgz.star.backend.models;

import io.ebean.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


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
public class Page extends Model {
  @Id
  @GeneratedValue(generator = "UUID")
  
  @Column(name = "id")
  private UUID id;

  @Column(name = "link")
  private String link;

  @ManyToOne
  @JoinColumn(name = "subject_id")
  private Subject subject;

  @ManyToMany(mappedBy = "page")
  private Set<Attachment> attachment;

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
