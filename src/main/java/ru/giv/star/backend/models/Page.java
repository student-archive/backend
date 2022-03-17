package ru.giv.star.backend.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import ru.giv.star.backend.models.Attachment;
import ru.giv.star.backend.models.Subject;
import org.openapitools.jackson.nullable.JsonNullable;
import javax.validation.Valid;
import javax.validation.constraints.*;

/** A page is a place where information is stored */
@ApiModel(description = "A page is a place where information is stored")
@javax.annotation.Generated(
    value = "org.openapitools.codegen.languages.SpringCodegen",
    date = "2022-03-17T11:30:21.915317900+03:00[Europe/Moscow]")
public class Page {
  @JsonProperty("id")
  private String id;

  @JsonProperty("link")
  private String link;

  @JsonProperty("subject")
  private Subject subject;

  @JsonProperty("attachments")
  @Valid
  private List<Attachment> attachments = null;

  public Page id(String id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   *
   * @return id
   */
  @ApiModelProperty(example = "b242e845-d182-4e85-b03c-b3e97000b483", required = true, value = "")
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

  public Page link(String link) {
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

  public Page subject(Subject subject) {
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

  public Page attachments(List<Attachment> attachments) {
    this.attachments = attachments;
    return this;
  }

  public Page addAttachmentsItem(Attachment attachmentsItem) {
    if (this.attachments == null) {
      this.attachments = new ArrayList<>();
    }
    this.attachments.add(attachmentsItem);
    return this;
  }

  /**
   * Get attachments
   *
   * @return attachments
   */
  @ApiModelProperty(value = "")
  @Valid
  public List<Attachment> getAttachments() {
    return attachments;
  }

  public void setAttachments(List<Attachment> attachments) {
    this.attachments = attachments;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Page page = (Page) o;
    return Objects.equals(this.id, page.id)
        && Objects.equals(this.link, page.link)
        && Objects.equals(this.subject, page.subject)
        && Objects.equals(this.attachments, page.attachments);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, link, subject, attachments);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Page {\n");

    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    link: ").append(toIndentedString(link)).append("\n");
    sb.append("    subject: ").append(toIndentedString(subject)).append("\n");
    sb.append("    attachments: ").append(toIndentedString(attachments)).append("\n");
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
