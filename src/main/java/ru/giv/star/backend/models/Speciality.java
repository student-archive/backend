package ru.giv.star.backend.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.openapitools.jackson.nullable.JsonNullable;
import javax.validation.Valid;
import javax.validation.constraints.*;

/** Education profile */
@ApiModel(description = "Education profile")
@javax.annotation.Generated(
    value = "org.openapitools.codegen.languages.SpringCodegen",
    date = "2022-03-17T11:30:21.915317900+03:00[Europe/Moscow]")
public class Speciality {
  @JsonProperty("id")
  private String id;

  @JsonProperty("specialityName")
  private String specialityName;

  public Speciality id(String id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   *
   * @return id
   */
  @ApiModelProperty(example = "f2dd849d-0daa-4a05-89df-078946aaade9", required = true, value = "")
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

  public Speciality specialityName(String specialityName) {
    this.specialityName = specialityName;
    return this;
  }

  /**
   * Get specialityName
   *
   * @return specialityName
   */
  @ApiModelProperty(required = true, value = "")
  @NotNull
  public String getSpecialityName() {
    return specialityName;
  }

  public void setSpecialityName(String specialityName) {
    this.specialityName = specialityName;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Speciality speciality = (Speciality) o;
    return Objects.equals(this.id, speciality.id)
        && Objects.equals(this.specialityName, speciality.specialityName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, specialityName);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Speciality {\n");

    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    specialityName: ").append(toIndentedString(specialityName)).append("\n");
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
