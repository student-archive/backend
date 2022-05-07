package ru.zgz.star.backend.models;

import io.ebean.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


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
public class Software extends Model {
  @Id
  @GeneratedValue(generator = "UUID")
  
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
