package ru.zgz.star.backend.models;

import io.ebean.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;
import java.util.UUID;


/**
 * Model for table <code>event_priority</code>.
 *
 * <p>Storing information about priorities of event
 *
 * @author ironalex
 */
@Entity
@Table(name = "event_priority")
public class EventPriority extends Model {

  @Id
  @GeneratedValue(generator = "UUID")
  
  @Column(name = "id")
  private UUID id;

  @Column(name = "priority_name")
  private String priorityName;

  @Column(name = "priority_description")
  private String priorityDescription;

  @OneToMany(mappedBy = "eventPriority")
  private Set<Event> events;

  public EventPriority() {}

  public EventPriority(String priorityName, String priorityDescription) {
    this.priorityName = priorityName;
    this.priorityDescription = priorityDescription;
  }

  /**
   * Sets value for ID
   *
   * @param id New ID of event priority
   */
  public EventPriority setId(UUID id) {
    this.id = id;
    return this;
  }

  /**
   * Returns ID
   *
   * @return ID of user
   */
  public UUID getId() {
    return id;
  }

  /**
   * Sets value for priority name
   *
   * @param priorityName New name of event priority
   */
  public EventPriority setPriorityName(String priorityName) {
    this.priorityName = priorityName;
    return this;
  }

  /**
   * Returns name of event priority
   *
   * @return Name of event priority
   */
  public String getPriorityName() {
    return priorityName;
  }

  /**
   * Sets value for priority name
   *
   * @param priorityDescription New name of event priority
   */
  public EventPriority setPriorityDescription(String priorityDescription) {
    this.priorityDescription = priorityDescription;
    return this;
  }

  /**
   * Returns name of event description
   *
   * @return Name of event description
   */
  public String getPriorityDescription() {
    return priorityDescription;
  }

  public Set<Event> getEvents() {
    return events;
  }

  public EventPriority setEvents(Set<Event> events) {
    this.events = events;
    return this;
  }
}
