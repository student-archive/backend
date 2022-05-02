package ru.zgz.star.backend.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.util.UUID;
import org.hibernate.annotations.GenericGenerator;

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
  private int eventDate;

  @ManyToOne
  @JoinColumn(name = "event_priority_id")
  private EventPriority eventPriority;

  @ManyToOne
  @JoinColumn(name = "user_id")
  private User user;

  @ManyToOne
  @JoinColumn(name = "group_id")
  private Group group;

  /** Instantiates a new Event. */
  public Event() {}

  /**
   * Instantiates a new Event.
   *
   * @param eventText the event text
   * @param eventDescription the event description
   * @param eventDate the event date
   */
  public Event(String eventText, String eventDescription, int eventDate) {
    this.eventText = eventText;
    this.eventDescription = eventDescription;
    this.eventDate = eventDate;
  }

  /**
   * Sets id.
   *
   * @param id the id
   * @return the id
   */
  public Event setId(UUID id) {
    this.id = id;
    return this;
  }

  /**
   * Gets id.
   *
   * @return the id
   */
  public UUID getId() {
    return id;
  }

  /**
   * Sets event text.
   *
   * @param eventText the event text
   * @return the event text
   */
  public Event setEventText(String eventText) {
    this.eventText = eventText;
    return this;
  }

  /**
   * Gets event text.
   *
   * @return the event text
   */
  public String getEventText() {
    return eventText;
  }

  /**
   * Sets event description.
   *
   * @param eventDescription the event description
   * @return the event description
   */
  public Event setEventDescription(String eventDescription) {
    this.eventDescription = eventDescription;
    return this;
  }

  /**
   * Gets event description.
   *
   * @return the event description
   */
  public String getEventDescription() {
    return eventDescription;
  }

  /**
   * Sets event date.
   *
   * @param eventDate the event date
   * @return the event date
   */
  public Event setEventDate(int eventDate) {
    this.eventDate = eventDate;
    return this;
  }

  /**
   * Gets event date.
   *
   * @return the event date
   */
  public int getEventDate() {
    return eventDate;
  }

  /**
   * Sets event priority.
   *
   * @param eventPriority the event priority
   * @return the event priority
   */
  public Event setEventPriority(EventPriority eventPriority) {
    this.eventPriority = eventPriority;
    return this;
  }

  /**
   * Gets event priority.
   *
   * @return the event priority
   */
  public EventPriority getEventPriority() {
    return eventPriority;
  }

  /**
   * Sets user.
   *
   * @param user the user
   * @return the user
   */
  public Event setUser(User user) {
    this.user = user;
    return this;
  }

  /**
   * Gets user.
   *
   * @return the user
   */
  public User getUser() {
    return user;
  }

  /**
   * Sets group.
   *
   * @param group the group
   * @return the group
   */
  public Event setGroup(Group group) {
    this.group = group;
    return this;
  }

  /**
   * Gets group.
   *
   * @return the group
   */
  public Group getGroup() {
    return group;
  }
}
