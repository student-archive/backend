package ru.giv.star.backend.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.openapitools.jackson.nullable.JsonNullable;
import javax.validation.Valid;
import javax.validation.constraints.*;

/** The level of access (system-wide and local per group) and the importance of the event */
@ApiModel(
    description =
        "The level of access (system-wide and local per group) and the importance of the event")
@javax.annotation.Generated(
    value = "org.openapitools.codegen.languages.SpringCodegen",
    date = "2022-03-17T11:30:21.915317900+03:00[Europe/Moscow]")
public class EventPriority {
  @JsonProperty("id")
  private String id;

  @JsonProperty("priorityName")
  private String priorityName;

  @JsonProperty("priorityDescription")
  private String priorityDescription;

  public EventPriority id(String id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   *
   * @return id
   */
  @ApiModelProperty(example = "aa85581d-ef4e-416c-a730-8a3f55ee6396", required = true, value = "")
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

  public EventPriority priorityName(String priorityName) {
    this.priorityName = priorityName;
    return this;
  }

  /**
   * Get priorityName
   *
   * @return priorityName
   */
  @ApiModelProperty(required = true, value = "")
  @NotNull
  public String getPriorityName() {
    return priorityName;
  }

  public void setPriorityName(String priorityName) {
    this.priorityName = priorityName;
  }

  public EventPriority priorityDescription(String priorityDescription) {
    this.priorityDescription = priorityDescription;
    return this;
  }

  /**
   * Get priorityDescription
   *
   * @return priorityDescription
   */
  @ApiModelProperty(value = "")
  public String getPriorityDescription() {
    return priorityDescription;
  }

  public void setPriorityDescription(String priorityDescription) {
    this.priorityDescription = priorityDescription;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    EventPriority eventPriority = (EventPriority) o;
    return Objects.equals(this.id, eventPriority.id)
        && Objects.equals(this.priorityName, eventPriority.priorityName)
        && Objects.equals(this.priorityDescription, eventPriority.priorityDescription);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, priorityName, priorityDescription);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class EventPriority {\n");

    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    priorityName: ").append(toIndentedString(priorityName)).append("\n");
    sb.append("    priorityDescription: ")
        .append(toIndentedString(priorityDescription))
        .append("\n");
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
