package ru.giv.star.backend.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.openapitools.jackson.nullable.JsonNullable;
import javax.validation.Valid;
import javax.validation.constraints.*;

/** Role of user */
@ApiModel(description = "Role of user")
@javax.annotation.Generated(
    value = "org.openapitools.codegen.languages.SpringCodegen",
    date = "2022-03-17T11:30:21.915317900+03:00[Europe/Moscow]")
public class Role {
  @JsonProperty("id")
  private String id;

  @JsonProperty("roleName")
  private String roleName;

  @JsonProperty("roleDescription")
  private String roleDescription;

  public Role id(String id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   *
   * @return id
   */
  @ApiModelProperty(example = "edfc5608-30b2-4408-bd87-5d0fa260bc4b", required = true, value = "")
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

  public Role roleName(String roleName) {
    this.roleName = roleName;
    return this;
  }

  /**
   * Get roleName
   *
   * @return roleName
   */
  @ApiModelProperty(required = true, value = "")
  @NotNull
  public String getRoleName() {
    return roleName;
  }

  public void setRoleName(String roleName) {
    this.roleName = roleName;
  }

  public Role roleDescription(String roleDescription) {
    this.roleDescription = roleDescription;
    return this;
  }

  /**
   * Get roleDescription
   *
   * @return roleDescription
   */
  @ApiModelProperty(value = "")
  public String getRoleDescription() {
    return roleDescription;
  }

  public void setRoleDescription(String roleDescription) {
    this.roleDescription = roleDescription;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Role role = (Role) o;
    return Objects.equals(this.id, role.id)
        && Objects.equals(this.roleName, role.roleName)
        && Objects.equals(this.roleDescription, role.roleDescription);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, roleName, roleDescription);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Role {\n");

    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    roleName: ").append(toIndentedString(roleName)).append("\n");
    sb.append("    roleDescription: ").append(toIndentedString(roleDescription)).append("\n");
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
