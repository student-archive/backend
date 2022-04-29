package ru.zgz.star.backend.models;

import jakarta.persistence.Column;
import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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

  @Id
  @GeneratedValue(generator = "UUID")
  @GenericGenerator(name = "uuid", strategy = "uuid2")
  @Column(name = "id")
  private UUID id;

  @Column(name = "priority_name")
  private String priorityName;

  @Column(name = "priority_description")
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
