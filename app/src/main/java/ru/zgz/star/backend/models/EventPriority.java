package ru.zgz.star.backend.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
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
public class EventPriority {

  private UUID id;
  private String priorityName;
  private String priorityDescription;

  /**
   * Sets value for ID
   *
   * @param id New ID of event priority
   */
  public void setId(UUID id) {
    this.id = id;
  }

  /**
   * Returns ID
   *
   * @return ID of user
   */
  @Id
  @GeneratedValue
  public UUID getId() {
    return id;
  }

  /**
   * Sets value for priority name
   *
   * @param priorityName New name of event priority
   */
  public void setPriorityName(String priorityName) {
    this.priorityName = priorityName;
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
  public void setPriorityDescription(String priorityDescription) {
    this.priorityDescription = priorityDescription;
  }

  /**
   * Returns name of event description
   *
   * @return Name of event description
   */
  public String getPriorityDescription() {
    return priorityDescription;
  }
}
