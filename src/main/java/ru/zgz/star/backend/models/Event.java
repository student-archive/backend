package ru.zgz.star.backend.models;

import java.util.UUID;

/**
 * Model for table <code>event</code>.
 *
 * <p>Storing events
 *
 * @author ironalex
 */
public class Event {
  private UUID id;
  private String eventText;
  private String eventDescription;
  private Integer eventDate;
  private UUID eventPriority;
  private UUID user;
  private UUID group;

  /** Instantiates a new Event. */
  public Event() {}

  /**
   * Instantiates a new Event.
   *
   * @param eventText the event text
   * @param eventDescription the event description
   * @param eventDate the event date
   */
  public Event(String eventText, String eventDescription, Integer eventDate) {
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
  public Event setEventDate(Integer eventDate) {
    this.eventDate = eventDate;
    return this;
  }

  /**
   * Gets event date.
   *
   * @return the event date
   */
  public Integer getEventDate() {
    return eventDate;
  }

  /**
   * Sets event priority.
   *
   * @param eventPriority the event priority
   * @return the event priority
   */
  public Event setEventPriority(UUID eventPriority) {
    this.eventPriority = eventPriority;
    return this;
  }

  /**
   * Gets event priority.
   *
   * @return the event priority
   */
  public UUID getEventPriority() {
    return eventPriority;
  }

  /**
   * Sets user.
   *
   * @param user the user
   * @return the user
   */
  public Event setUser(UUID user) {
    this.user = user;
    return this;
  }

  /**
   * Gets user.
   *
   * @return the user
   */
  public UUID getUser() {
    return user;
  }

  /**
   * Sets group.
   *
   * @param group the group
   * @return the group
   */
  public Event setGroup(UUID group) {
    this.group = group;
    return this;
  }

  /**
   * Gets group.
   *
   * @return the group
   */
  public UUID getGroup() {
    return group;
  }
}
