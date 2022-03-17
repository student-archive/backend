package ru.giv.star.backend.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/** A collection of students */
@ApiModel(description = "A collection of students")
@javax.annotation.Generated(
    value = "org.openapitools.codegen.languages.SpringCodegen",
    date = "2022-03-17T11:30:21.915317900+03:00[Europe/Moscow]")
public class Group {
  @JsonProperty("id")
  private String id;

  @JsonProperty("speciality")
  private Speciality speciality;

  @JsonProperty("groupNumber")
  private String groupNumber;

  @JsonProperty("students")
  @Valid
  private List<User> students = null;

  public Group id(String id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   *
   * @return id
   */
  @ApiModelProperty(example = "b3120bb1-02f4-4260-b93f-ceca1fdd286d", required = true, value = "")
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

  public Group speciality(Speciality speciality) {
    this.speciality = speciality;
    return this;
  }

  /**
   * Get speciality
   *
   * @return speciality
   */
  @ApiModelProperty(required = true, value = "")
  @NotNull
  @Valid
  public Speciality getSpeciality() {
    return speciality;
  }

  public void setSpeciality(Speciality speciality) {
    this.speciality = speciality;
  }

  public Group groupNumber(String groupNumber) {
    this.groupNumber = groupNumber;
    return this;
  }

  /**
   * Get groupNumber
   *
   * @return groupNumber
   */
  @ApiModelProperty(required = true, value = "")
  @NotNull
  public String getGroupNumber() {
    return groupNumber;
  }

  public void setGroupNumber(String groupNumber) {
    this.groupNumber = groupNumber;
  }

  public Group students(List<User> students) {
    this.students = students;
    return this;
  }

  public Group addStudentsItem(User studentsItem) {
    if (this.students == null) {
      this.students = new ArrayList<>();
    }
    this.students.add(studentsItem);
    return this;
  }

  /**
   * Get students
   *
   * @return students
   */
  @ApiModelProperty(value = "")
  @Valid
  public List<User> getStudents() {
    return students;
  }

  public void setStudents(List<User> students) {
    this.students = students;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Group group = (Group) o;
    return Objects.equals(this.id, group.id)
        && Objects.equals(this.speciality, group.speciality)
        && Objects.equals(this.groupNumber, group.groupNumber)
        && Objects.equals(this.students, group.students);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, speciality, groupNumber, students);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Group {\n");

    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    speciality: ").append(toIndentedString(speciality)).append("\n");
    sb.append("    groupNumber: ").append(toIndentedString(groupNumber)).append("\n");
    sb.append("    students: ").append(toIndentedString(students)).append("\n");
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
