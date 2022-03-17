package ru.giv.star.backend.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import ru.giv.star.backend.models.AnyOfPageAttachmentQuizSoftwareQuestionQuizVariant;
import org.openapitools.jackson.nullable.JsonNullable;
import javax.validation.Valid;
import javax.validation.constraints.*;

/** InlineResponse200 */
@javax.annotation.Generated(
    value = "org.openapitools.codegen.languages.SpringCodegen",
    date = "2022-03-17T11:30:21.915317900+03:00[Europe/Moscow]")
public class InlineResponse200 {
  @JsonProperty("id")
  private String id;

  @JsonProperty("deletedContent")
  private AnyOfPageAttachmentQuizSoftwareQuestionQuizVariant deletedContent = null;

  public InlineResponse200 id(String id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   *
   * @return id
   */
  @ApiModelProperty(value = "")
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public InlineResponse200 deletedContent(
      AnyOfPageAttachmentQuizSoftwareQuestionQuizVariant deletedContent) {
    this.deletedContent = deletedContent;
    return this;
  }

  /**
   * Get deletedContent
   *
   * @return deletedContent
   */
  @ApiModelProperty(value = "")
  @Valid
  public AnyOfPageAttachmentQuizSoftwareQuestionQuizVariant getDeletedContent() {
    return deletedContent;
  }

  public void setDeletedContent(AnyOfPageAttachmentQuizSoftwareQuestionQuizVariant deletedContent) {
    this.deletedContent = deletedContent;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    InlineResponse200 inlineResponse200 = (InlineResponse200) o;
    return Objects.equals(this.id, inlineResponse200.id)
        && Objects.equals(this.deletedContent, inlineResponse200.deletedContent);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, deletedContent);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class InlineResponse200 {\n");

    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    deletedContent: ").append(toIndentedString(deletedContent)).append("\n");
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
