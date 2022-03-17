package ru.giv.star.backend.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import ru.giv.star.backend.models.Speciality;
import org.openapitools.jackson.nullable.JsonNullable;
import javax.validation.Valid;
import javax.validation.constraints.*;

/** List of useful contacts */
@ApiModel(description = "List of useful contacts")
@javax.annotation.Generated(
    value = "org.openapitools.codegen.languages.SpringCodegen",
    date = "2022-03-17T11:30:21.915317900+03:00[Europe/Moscow]")
public class Employee {
  @JsonProperty("id")
  private String id;

  @JsonProperty("specialities")
  @Valid
  private List<Speciality> specialities = new ArrayList<>();

  @JsonProperty("firstName")
  private String firstName;

  @JsonProperty("lastName")
  private String lastName;

  @JsonProperty("patronym")
  private String patronym;

  @JsonProperty("position")
  private String position;

  @JsonProperty("email")
  private String email;

  @JsonProperty("phone")
  private String phone;

  @JsonProperty("link")
  private String link;

  public Employee id(String id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   *
   * @return id
   */
  @ApiModelProperty(example = "9a611d64-37b7-40ff-a25d-5f310d4759cc", required = true, value = "")
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

  public Employee specialities(List<Speciality> specialities) {
    this.specialities = specialities;
    return this;
  }

  public Employee addSpecialitiesItem(Speciality specialitiesItem) {
    this.specialities.add(specialitiesItem);
    return this;
  }

  /**
   * Get specialities
   *
   * @return specialities
   */
  @ApiModelProperty(required = true, value = "")
  @NotNull
  @Valid
  public List<Speciality> getSpecialities() {
    return specialities;
  }

  public void setSpecialities(List<Speciality> specialities) {
    this.specialities = specialities;
  }

  public Employee firstName(String firstName) {
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

  public Employee lastName(String lastName) {
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

  public Employee patronym(String patronym) {
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

  public Employee position(String position) {
    this.position = position;
    return this;
  }

  /**
   * Get position
   *
   * @return position
   */
  @ApiModelProperty(required = true, value = "")
  @NotNull
  public String getPosition() {
    return position;
  }

  public void setPosition(String position) {
    this.position = position;
  }

  public Employee email(String email) {
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

  public Employee phone(String phone) {
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

  public Employee link(String link) {
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

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Employee employee = (Employee) o;
    return Objects.equals(this.id, employee.id)
        && Objects.equals(this.specialities, employee.specialities)
        && Objects.equals(this.firstName, employee.firstName)
        && Objects.equals(this.lastName, employee.lastName)
        && Objects.equals(this.patronym, employee.patronym)
        && Objects.equals(this.position, employee.position)
        && Objects.equals(this.email, employee.email)
        && Objects.equals(this.phone, employee.phone)
        && Objects.equals(this.link, employee.link);
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        id, specialities, firstName, lastName, patronym, position, email, phone, link);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Employee {\n");

    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    specialities: ").append(toIndentedString(specialities)).append("\n");
    sb.append("    firstName: ").append(toIndentedString(firstName)).append("\n");
    sb.append("    lastName: ").append(toIndentedString(lastName)).append("\n");
    sb.append("    patronym: ").append(toIndentedString(patronym)).append("\n");
    sb.append("    position: ").append(toIndentedString(position)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    phone: ").append(toIndentedString(phone)).append("\n");
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
