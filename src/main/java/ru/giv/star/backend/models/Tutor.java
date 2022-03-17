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

/** University employee, who teachs students */
@ApiModel(description = "University employee, who teachs students")
@javax.annotation.Generated(
    value = "org.openapitools.codegen.languages.SpringCodegen",
    date = "2022-03-17T11:30:21.915317900+03:00[Europe/Moscow]")
public class Tutor {
  @JsonProperty("id")
  private String id;

  @JsonProperty("firstName")
  private String firstName;

  @JsonProperty("lastName")
  private String lastName;

  @JsonProperty("patronym")
  private String patronym;

  @JsonProperty("email")
  private String email;

  @JsonProperty("phone")
  private String phone;

  @JsonProperty("link")
  private String link;

  @JsonProperty("subjects")
  @Valid
  private List<Subject> subjects = new ArrayList<>();

  public Tutor id(String id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   *
   * @return id
   */
  @ApiModelProperty(example = "8fae1554-9e9c-4ea3-8104-35ad1d97a05c", required = true, value = "")
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

  public Tutor firstName(String firstName) {
    this.firstName = firstName;
    return this;
  }

  /**
   * Get firstName
   *
   * @return firstName
   */
  @ApiModelProperty(required = true, value = "")
  @NotNull
  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public Tutor lastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

  /**
   * Get lastName
   *
   * @return lastName
   */
  @ApiModelProperty(required = true, value = "")
  @NotNull
  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public Tutor patronym(String patronym) {
    this.patronym = patronym;
    return this;
  }

  /**
   * Get patronym
   *
   * @return patronym
   */
  @ApiModelProperty(value = "")
  public String getPatronym() {
    return patronym;
  }

  public void setPatronym(String patronym) {
    this.patronym = patronym;
  }

  public Tutor email(String email) {
    this.email = email;
    return this;
  }

  /**
   * Get email
   *
   * @return email
   */
  @ApiModelProperty(value = "")
  @Pattern(regexp = "^[^@ \\t\\r\\n]+@[^@ \\t\\r\\n]+\\.[^@ \\t\\r\\n]+$")
  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Tutor phone(String phone) {
    this.phone = phone;
    return this;
  }

  /**
   * Get phone
   *
   * @return phone
   */
  @ApiModelProperty(value = "")
  @Pattern(regexp = "^\\+[1-9]\\d{1,14}$")
  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public Tutor link(String link) {
    this.link = link;
    return this;
  }

  /**
   * Get link
   *
   * @return link
   */
  @ApiModelProperty(value = "")
  @Pattern(
      regexp =
          "^https?://(www\\.)?[-a-zA-Z0-9@:%._\\+~#=]{1,256}\\.[a-zA-Z0-9()]{1,6}\\b([-a-zA-Z0-9()!@:%_\\+.~#?&//=]*)$")
  public String getLink() {
    return link;
  }

  public void setLink(String link) {
    this.link = link;
  }

  public Tutor subjects(List<Subject> subjects) {
    this.subjects = subjects;
    return this;
  }

  public Tutor addSubjectsItem(Subject subjectsItem) {
    this.subjects.add(subjectsItem);
    return this;
  }

  /**
   * Get subjects
   *
   * @return subjects
   */
  @ApiModelProperty(required = true, value = "")
  @NotNull
  @Valid
  public List<Subject> getSubjects() {
    return subjects;
  }

  public void setSubjects(List<Subject> subjects) {
    this.subjects = subjects;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Tutor tutor = (Tutor) o;
    return Objects.equals(this.id, tutor.id)
        && Objects.equals(this.firstName, tutor.firstName)
        && Objects.equals(this.lastName, tutor.lastName)
        && Objects.equals(this.patronym, tutor.patronym)
        && Objects.equals(this.email, tutor.email)
        && Objects.equals(this.phone, tutor.phone)
        && Objects.equals(this.link, tutor.link)
        && Objects.equals(this.subjects, tutor.subjects);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, firstName, lastName, patronym, email, phone, link, subjects);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Tutor {\n");

    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    firstName: ").append(toIndentedString(firstName)).append("\n");
    sb.append("    lastName: ").append(toIndentedString(lastName)).append("\n");
    sb.append("    patronym: ").append(toIndentedString(patronym)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    phone: ").append(toIndentedString(phone)).append("\n");
    sb.append("    link: ").append(toIndentedString(link)).append("\n");
    sb.append("    subjects: ").append(toIndentedString(subjects)).append("\n");
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
