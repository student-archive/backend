package ru.zgz.star.backend.models;

import java.util.List;
import java.util.UUID;

/**
 * Model for table <code>page</code>.
 *
 * <p>Storing attachments
 *
 * @author ironalex
 */

public class Page {

  private UUID id;
  private String link;
  private UUID subject;


  public Page() {}

  public Page(String link, UUID subject, List<Attachment> attachment) {
    this.link = link;
    this.subject = subject;
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

  public Page setSubject(UUID subject) {
    this.subject = subject;
    return this;
  }

  public UUID getSubject() {
    return subject;
  }
}
