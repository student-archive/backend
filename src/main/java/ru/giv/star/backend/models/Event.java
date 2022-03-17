package ru.giv.star.backend.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Objects;

/** System notification */
@ApiModel(description = "System notification")
@javax.annotation.Generated(
    value = "org.openapitools.codegen.languages.SpringCodegen",
    date = "2022-03-17T11:30:21.915317900+03:00[Europe/Moscow]")
public class Event {
  @JsonProperty("id")
  private String id;

  @JsonProperty("eventPriority")
  private EventPriority eventPriority;

  @JsonProperty("group")
  private Group group;

  @JsonProperty("eventText")
  private String eventText;

  @JsonProperty("eventDescription")
  private String eventDescription;

  @JsonProperty("eventDate")
  private Integer eventDate;

  public Event id(String id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   *
   * @return id
   */
  @ApiModelProperty(example = "5cbf66de-9a4e-4380-beac-2421f9a26cf4", required = true, value = "")
  @NotNull
  @Pattern(
      regexp =
          "^[0-9a-fA-F]{8}\\b-[0-9a-fA-F]{4}\\b-[0-9a-fA-F]{4}\\b-[0-9a-fA-F]{4}\\b-[0-9a-fA-F]{12}$")
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public Event eventPriority(EventPriority eventPriority) {
    this.eventPriority = eventPriority;
    return this;
  }

  /**
   * Get eventPriority
   *
   * @return eventPriority
   */
  @ApiModelProperty(required = true, value = "")
  @NotNull
  @Valid
  public EventPriority getEventPriority() {
    return eventPriority;
  }

  public void setEventPriority(EventPriority eventPriority) {
    this.eventPriority = eventPriority;
  }

  public Event group(Group group) {
    this.group = group;
    return this;
  }

  /**
   * Get group
   *
   * @return group
   */
  @ApiModelProperty(value = "")
  @Valid
  public Group getGroup() {
    return group;
  }

  public void setGroup(Group group) {
    this.group = group;
  }

  public Event eventText(String eventText) {
    this.eventText = eventText;
    return this;
  }

  /**
   * Get eventText
   *
   * @return eventText
   */
  @ApiModelProperty(required = true, value = "")
  @NotNull
  public String getEventText() {
    return eventText;
  }

  public void setEventText(String eventText) {
    this.eventText = eventText;
  }

  public Event eventDescription(String eventDescription) {
    this.eventDescription = eventDescription;
    return this;
  }

  /**
   * Get eventDescription
   *
   * @return eventDescription
   */
  @ApiModelProperty(value = "")
  public String getEventDescription() {
    return eventDescription;
  }

  public void setEventDescription(String eventDescription) {
    this.eventDescription = eventDescription;
  }

  public Event eventDate(Integer eventDate) {
    this.eventDate = eventDate;
    return this;
  }

  /**
   * Get eventDate
   *
   * @return eventDate
   */
  @ApiModelProperty(example = "1647159287", required = true, value = "")
  @NotNull
  public Integer getEventDate() {
    return eventDate;
  }

  public void setEventDate(Integer eventDate) {
    this.eventDate = eventDate;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Event event = (Event) o;
    return Objects.equals(this.id, event.id)
        && Objects.equals(this.eventPriority, event.eventPriority)
        && Objects.equals(this.group, event.group)
        && Objects.equals(this.eventText, event.eventText)
        && Objects.equals(this.eventDescription, event.eventDescription)
        && Objects.equals(this.eventDate, event.eventDate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, eventPriority, group, eventText, eventDescription, eventDate);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Event {\n");

    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    eventPriority: ").append(toIndentedString(eventPriority)).append("\n");
    sb.append("    group: ").append(toIndentedString(group)).append("\n");
    sb.append("    eventText: ").append(toIndentedString(eventText)).append("\n");
    sb.append("    eventDescription: ").append(toIndentedString(eventDescription)).append("\n");
    sb.append("    eventDate: ").append(toIndentedString(eventDate)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
