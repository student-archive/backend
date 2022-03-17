package ru.giv.star.backend.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/** Information about training course */
@ApiModel(description = "Information about training course")
@javax.annotation.Generated(
    value = "org.openapitools.codegen.languages.SpringCodegen",
    date = "2022-03-17T11:30:21.915317900+03:00[Europe/Moscow]")
public class Subject {
  @JsonProperty("id")
  private String id;

  @JsonProperty("subjectName")
  private String subjectName;

  @JsonProperty("semester")
  private Integer semester;

  @JsonProperty("group")
  private Group group;

  @JsonProperty("tutors")
  @Valid
  private List<Tutor> tutors = new ArrayList<>();

  public Subject id(String id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   *
   * @return id
   */
  @ApiModelProperty(example = "0b5f18cd-3907-4fd1-b64f-bd5d44fc5f66", required = true, value = "")
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

  public Subject subjectName(String subjectName) {
    this.subjectName = subjectName;
    return this;
  }

  /**
   * Get subjectName
   *
   * @return subjectName
   */
  @ApiModelProperty(required = true, value = "")
  @NotNull
  public String getSubjectName() {
    return subjectName;
  }

  public void setSubjectName(String subjectName) {
    this.subjectName = subjectName;
  }

  public Subject semester(Integer semester) {
    this.semester = semester;
    return this;
  }

  /**
   * Get semester minimum: 1
   *
   * @return semester
   */
  @ApiModelProperty(example = "3", required = true, value = "")
  @NotNull
  @Min(1)
  public Integer getSemester() {
    return semester;
  }

  public void setSemester(Integer semester) {
    this.semester = semester;
  }

  public Subject group(Group group) {
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

  public Subject tutors(List<Tutor> tutors) {
    this.tutors = tutors;
    return this;
  }

  public Subject addTutorsItem(Tutor tutorsItem) {
    this.tutors.add(tutorsItem);
    return this;
  }

  /**
   * Get tutors
   *
   * @return tutors
   */
  @ApiModelProperty(required = true, value = "")
  @NotNull
  @Valid
  public List<Tutor> getTutors() {
    return tutors;
  }

  public void setTutors(List<Tutor> tutors) {
    this.tutors = tutors;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Subject subject = (Subject) o;
    return Objects.equals(this.id, subject.id)
        && Objects.equals(this.subjectName, subject.subjectName)
        && Objects.equals(this.semester, subject.semester)
        && Objects.equals(this.group, subject.group)
        && Objects.equals(this.tutors, subject.tutors);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, subjectName, semester, group, tutors);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Subject {\n");

    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    subjectName: ").append(toIndentedString(subjectName)).append("\n");
    sb.append("    semester: ").append(toIndentedString(semester)).append("\n");
    sb.append("    group: ").append(toIndentedString(group)).append("\n");
    sb.append("    tutors: ").append(toIndentedString(tutors)).append("\n");
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
