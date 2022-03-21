package ru.zgz.star.backend.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "eventPriority")
public class EventPriority {

  private UUID id;
  private String priorityName;
  private String priorityDescription;

  public void setId(UUID id) {
    this.id = id;
  }

  @Id
  @GeneratedValue
  public UUID getId() {
    return id;
  }

  public void setPriorityName(String priorityName) {
    this.priorityName = priorityName;
  }

  public String getPriorityName() {
    return priorityName;
  }

  public void setPriorityDescription(String priorityDescription) {
    this.priorityDescription = priorityDescription;
  }

  public String getPriorityDescription() {
    return priorityDescription;
  }
}
