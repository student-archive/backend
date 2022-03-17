package ru.giv.star.backend.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Objects;

/** Temporary storage of deleted pages */
@ApiModel(description = "Temporary storage of deleted pages")
@javax.annotation.Generated(
    value = "org.openapitools.codegen.languages.SpringCodegen",
    date = "2022-03-17T11:30:21.915317900+03:00[Europe/Moscow]")
public class Trash {
  @JsonProperty("id")
  private String id;

  @JsonProperty("deletedId")
  private String deletedId;

  @JsonProperty("deleteDate")
  private Integer deleteDate;

  @JsonProperty("group")
  private Group group;

  public Trash id(String id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   *
   * @return id
   */
  @ApiModelProperty(example = "2a1dbd41-b900-4d0a-9180-5fe58e569dc4", required = true, value = "")
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

  public Trash deletedId(String deletedId) {
    this.deletedId = deletedId;
    return this;
  }

  /**
   * Get deletedId
   *
   * @return deletedId
   */
  @ApiModelProperty(example = "115e1da5-6dfd-41dc-818f-184c59b4714e", required = true, value = "")
  @NotNull
  public String getDeletedId() {
    return deletedId;
  }

  public void setDeletedId(String deletedId) {
    this.deletedId = deletedId;
  }

  public Trash deleteDate(Integer deleteDate) {
    this.deleteDate = deleteDate;
    return this;
  }

  /**
   * Get deleteDate
   *
   * @return deleteDate
   */
  @ApiModelProperty(example = "1647159287", required = true, value = "")
  @NotNull
  public Integer getDeleteDate() {
    return deleteDate;
  }

  public void setDeleteDate(Integer deleteDate) {
    this.deleteDate = deleteDate;
  }

  public Trash group(Group group) {
    this.group = group;
    return this;
  }

  /**
   * Get group
   *
   * @return group
   */
  @ApiModelProperty(required = true, value = "")
  @NotNull
  @Valid
  public Group getGroup() {
    return group;
  }

  public void setGroup(Group group) {
    this.group = group;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Trash trash = (Trash) o;
    return Objects.equals(this.id, trash.id)
        && Objects.equals(this.deletedId, trash.deletedId)
        && Objects.equals(this.deleteDate, trash.deleteDate)
        && Objects.equals(this.group, trash.group);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, deletedId, deleteDate, group);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Trash {\n");

    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    deletedId: ").append(toIndentedString(deletedId)).append("\n");
    sb.append("    deleteDate: ").append(toIndentedString(deleteDate)).append("\n");
    sb.append("    group: ").append(toIndentedString(group)).append("\n");
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
