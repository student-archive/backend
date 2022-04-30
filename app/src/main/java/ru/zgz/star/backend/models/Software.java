package ru.zgz.star.backend.models;

import jakarta.persistence.*;
import java.util.UUID;

/**
 * Model for table <code>software</code>.
 *
 * <p>Storing softwares
 *
 * @author ironalex
 */
@Entity
@Table(name = "software")
public class Software {
  private UUID id;
  private String description;
  private String link;

  @ManyToOne private Subject subject;

  public void setId(UUID id) {
    this.id = id;
  }

  @Id
  @GeneratedValue
  public UUID getId() {
    return id;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getDescription() {
    return description;
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
}
