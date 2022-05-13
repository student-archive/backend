package ru.zgz.star.backend.models;

import java.util.List;
import java.util.UUID;

/**
 * Model for table <code>event_priority</code>.
 *
 * <p>Storing information about priorities of event
 *
 * @author ironalex
 */
public class EventPriority {
  private UUID id;
  private String priorityName;
  private String priorityDescription;


  /** Instantiates a new empty object. */
  public EventPriority() {}

  /**
   * Instantiates a new object with specified parameters.
   *
   * @param priorityName Name of event priority
   * @param priorityDescription Description of event priority
   */
  public EventPriority(String priorityName, String priorityDescription) {
    this.priorityName = priorityName;
    this.priorityDescription = priorityDescription;
  }

  /**
   * Sets value for ID.
   *
   * @param id New ID of event priority
   * @return object with new event priority
   */
  public EventPriority setId(UUID id) {
    this.id = id;
    return this;
  }

  /**
   * Returns ID.
   *
   * @return ID of user
   */
  public UUID getId() {
    return id;
  }

  /**
   * Sets value for priority name.
   *
   * @param priorityName New name of event priority
   * @return object with new event priority's name
   */
  public EventPriority setPriorityName(String priorityName) {
    this.priorityName = priorityName;
    return this;
  }

  /**
   * Returns name of event priority.
   *
   * @return Name of event priority
   */
  public String getPriorityName() {
    return priorityName;
  }

  /**
   * Sets value for priority name.
   *
   * @param priorityDescription New description of event priority
   * @return object with new event priority's description
   */
  public EventPriority setPriorityDescription(String priorityDescription) {
    this.priorityDescription = priorityDescription;
    return this;
  }

  /**
   * Returns name of event description.
   *
   * @return Name of event description
   */
  public String getPriorityDescription() {
    return priorityDescription;
  }


  }

