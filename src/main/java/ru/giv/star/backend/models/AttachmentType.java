package ru.giv.star.backend.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.openapitools.jackson.nullable.JsonNullable;
import javax.validation.Valid;
import javax.validation.constraints.*;

/** Type of attachment (example, solution, etc) */
@ApiModel(description = "Type of attachment (example, solution, etc)")
@javax.annotation.Generated(
    value = "org.openapitools.codegen.languages.SpringCodegen",
    date = "2022-03-17T11:30:21.915317900+03:00[Europe/Moscow]")
public class AttachmentType {
  @JsonProperty("id")
  private String id;

  @JsonProperty("typeName")
  private String typeName;

  public AttachmentType id(String id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   *
   * @return id
   */
  @ApiModelProperty(example = "383a40fd-9fdb-467b-a1bb-1b1432fa73e0", required = true, value = "")
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

  public AttachmentType typeName(String typeName) {
    this.typeName = typeName;
    return this;
  }

  /**
   * Get typeName
   *
   * @return typeName
   */
  @ApiModelProperty(required = true, value = "")
  @NotNull
  public String getTypeName() {
    return typeName;
  }

  public void setTypeName(String typeName) {
    this.typeName = typeName;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AttachmentType attachmentType = (AttachmentType) o;
    return Objects.equals(this.id, attachmentType.id)
        && Objects.equals(this.typeName, attachmentType.typeName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, typeName);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AttachmentType {\n");

    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    typeName: ").append(toIndentedString(typeName)).append("\n");
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
