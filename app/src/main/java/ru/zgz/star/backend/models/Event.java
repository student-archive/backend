package ru.zgz.star.backend.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

import java.time.Instant;
import java.util.UUID;

/**
 * Model for table <code>event</code>.
 *
 * <p>Storing events
 *
 * @author ironalex
 */
@Entity
@Table(name = "event")
public class Event {
  @Id
  @GeneratedValue(generator = "UUID")
  @GenericGenerator(name = "uuid", strategy = "uuid2")
  @Column(name = "id")
  private UUID id;

  @Column(name = "event_text")
  private String eventText;

  @Column(name = "event_description")
  private String eventDescription;

  @Column(name = "event_date")
  private Instant eventDate;

  @ManyToOne private EventPriority eventPriority;
  @ManyToOne private User user;
  @ManyToOne private Group group;

  public Event() {}

  public Event(String eventText, String eventDescription, Instant eventDate) {
    this.eventText = eventText;
    this.eventDescription = eventDescription;
    this.eventDate = eventDate;
  }

  public Event setId(UUID id) {
    this.id = id;
    return this;
  }

  public UUID getId() {
    return id;
  }

  public Event setEventText(String eventText) {
    this.eventText = eventText;
    return this;
  }

  public String getEventText() {
    return eventText;
  }

  public Event setEventDescription(String eventDescription) {
    this.eventDescription = eventDescription;
    return this;
  }

  public String getEventDescription() {
    return eventDescription;
  }

  public Event setEventDate(Instant eventDate) {
    this.eventDate = eventDate;
    return this;
  }

  public Instant getEventDate() {
    return eventDate;
  }

  public Event setEventPriority(EventPriority eventPriority) {
    this.eventPriority = eventPriority;
    return this;
  }

  public EventPriority getEventPriority() {
    return eventPriority;
  }

  public Event setUser(User user) {
    this.user = user;
    return this;
  }

  public User getUser() {
    return user;
  }

  public Event setGroup(Group group) {
    this.group = group;
    return this;
  }

  public Group getGroup() {
    return group;
  }
}
