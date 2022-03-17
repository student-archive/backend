package ru.giv.star.backend.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import ru.giv.star.backend.models.AttachmentType;
import org.openapitools.jackson.nullable.JsonNullable;
import javax.validation.Valid;
import javax.validation.constraints.*;

/** Attachments - file management system */
@ApiModel(description = "Attachments - file management system")
@javax.annotation.Generated(
    value = "org.openapitools.codegen.languages.SpringCodegen",
    date = "2022-03-17T11:30:21.915317900+03:00[Europe/Moscow]")
public class Attachment {
  @JsonProperty("id")
  private String id;

  @JsonProperty("type")
  private AttachmentType type;

  @JsonProperty("link")
  private String link;

  public Attachment id(String id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   *
   * @return id
   */
  @ApiModelProperty(example = "2ceacea5-6831-48f0-856a-3551d375fd89", required = true, value = "")
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

  public Attachment type(AttachmentType type) {
    this.type = type;
    return this;
  }

  /**
   * Get type
   *
   * @return type
   */
  @ApiModelProperty(required = true, value = "")
  @NotNull
  @Valid
  public AttachmentType getType() {
    return type;
  }

  public void setType(AttachmentType type) {
    this.type = type;
  }

  public Attachment link(String link) {
    this.link = link;
    return this;
  }

  /**
   * Get link
   *
   * @return link
   */
  @ApiModelProperty(required = true, value = "")
  @NotNull
  @Pattern(
      regexp =
          "^https?://(www\\.)?[-a-zA-Z0-9@:%._\\+~#=]{1,256}\\.[a-zA-Z0-9()]{1,6}\\b([-a-zA-Z0-9()!@:%_\\+.~#?&//=]*)$")
  public String getLink() {
    return link;
  }

  public void setLink(String link) {
    this.link = link;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Attachment attachment = (Attachment) o;
    return Objects.equals(this.id, attachment.id)
        && Objects.equals(this.type, attachment.type)
        && Objects.equals(this.link, attachment.link);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, type, link);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Attachment {\n");

    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    link: ").append(toIndentedString(link)).append("\n");
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
