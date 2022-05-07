package ru.zgz.star.backend.models;

import java.util.UUID;

/**
 * Model for table <code>software</code>.
 *
 * <p>Storing softwares
 *
 * @author ironalex
 */
public class Software {

  private UUID id;
  private String description;
  private String link;
  private Subject subject;

  public Software() {}

  public Software(String description, String link) {
    this.description = description;
    this.link = link;
  }

  public Software setId(UUID id) {
    this.id = id;
    return this;
  }

  public UUID getId() {
    return id;
  }

  public Software setDescription(String description) {
    this.description = description;
    return this;
  }

  public String getDescription() {
    return description;
  }

  public Software setLink(String link) {
    this.link = link;
    return this;
  }

  public String getLink() {
    return link;
  }

  public Software setSubject(Subject subject) {
    this.subject = subject;
    return this;
  }

  public Subject getSubject() {
    return subject;
  }
}
