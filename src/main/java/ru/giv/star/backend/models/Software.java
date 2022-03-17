package ru.giv.star.backend.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import ru.giv.star.backend.models.Subject;
import org.openapitools.jackson.nullable.JsonNullable;
import javax.validation.Valid;
import javax.validation.constraints.*;

/** Software - programs necessary for education process */
@ApiModel(description = "Software - programs necessary for education process")
@javax.annotation.Generated(
    value = "org.openapitools.codegen.languages.SpringCodegen",
    date = "2022-03-17T11:30:21.915317900+03:00[Europe/Moscow]")
public class Software {
  @JsonProperty("id")
  private String id;

  @JsonProperty("link")
  private String link;

  @JsonProperty("subject")
  private Subject subject;

  public Software id(String id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   *
   * @return id
   */
  @ApiModelProperty(example = "ac29b22b-4338-4edc-8332-a045bc0fc9ce", required = true, value = "")
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

  public Software link(String link) {
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

  public Software subject(Subject subject) {
    this.subject = subject;
    return this;
  }

  /**
   * Get subject
   *
   * @return subject
   */
  @ApiModelProperty(required = true, value = "")
  @NotNull
  @Valid
  public Subject getSubject() {
    return subject;
  }

  public void setSubject(Subject subject) {
    this.subject = subject;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Software software = (Software) o;
    return Objects.equals(this.id, software.id)
        && Objects.equals(this.link, software.link)
        && Objects.equals(this.subject, software.subject);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, link, subject);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Software {\n");

    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    link: ").append(toIndentedString(link)).append("\n");
    sb.append("    subject: ").append(toIndentedString(subject)).append("\n");
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
