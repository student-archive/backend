package ru.zgz.star.backend.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

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
  @Id
  @GeneratedValue(generator = "UUID")
  @GenericGenerator(name = "uuid", strategy = "uuid2")
  @Column(name = "id")
  private UUID id;

  @Column(name = "description")
  private String description;

  @Column(name = "link")
  private String link;

  @ManyToOne
  @JoinColumn(name = "subject_id")
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
