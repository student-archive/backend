package ru.zgz.star.backend.models;

import jakarta.persistence.*;
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
  private UUID id;
  private String eventText;
  private String eventDescription;
  private Instant eventDate;

  @ManyToOne private EventPriority eventPriority;
  @ManyToOne private User user;
  @ManyToOne private Group group;

  public void setId(UUID id) {
    this.id = id;
  }

  @Id
  @GeneratedValue
  public UUID getId() {
    return id;
  }

  public void setEventText(String eventText) {
    this.eventText = eventText;
  }

  public String getEventText() {
    return eventText;
  }

  public void setEventDescription(String eventDescription) {
    this.eventDescription = eventDescription;
  }

  public String getEventDescription() {
    return eventDescription;
  }

  public void setEventDate(Instant eventDate) {
    this.eventDate = eventDate;
  }

  public Instant getEventDate() {
    return eventDate;
  }

  public void setEventPriority(EventPriority eventPriority) {
    this.eventPriority = eventPriority;
  }

  public EventPriority getEventPriority() {
    return eventPriority;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public User getUser() {
    return user;
  }

  public void setGroup(Group group) {
    this.group = group;
  }

  public Group getGroup() {
    return group;
  }
}
