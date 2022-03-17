package ru.giv.star.backend.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.openapitools.jackson.nullable.JsonNullable;
import javax.validation.Valid;
import javax.validation.constraints.*;

/** Authentication information about users */
@ApiModel(description = "Authentication information about users")
@javax.annotation.Generated(
    value = "org.openapitools.codegen.languages.SpringCodegen",
    date = "2022-03-17T11:30:21.915317900+03:00[Europe/Moscow]")
public class Account {
  @JsonProperty("id")
  private String id;

  @JsonProperty("username")
  private String username;

  @JsonProperty("passwordHash")
  private String passwordHash;

  @JsonProperty("lastLoginDate")
  private Integer lastLoginDate;

  public Account id(String id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   *
   * @return id
   */
  @ApiModelProperty(example = "99167df3-123e-4d1b-9542-3950c7eeef28", required = true, value = "")
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

  public Account username(String username) {
    this.username = username;
    return this;
  }

  /**
   * Get username
   *
   * @return username
   */
  @ApiModelProperty(example = "ejik", required = true, value = "")
  @NotNull
  @Pattern(regexp = "^[a-z0-9_-]{3,15}$")
  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public Account passwordHash(String passwordHash) {
    this.passwordHash = passwordHash;
    return this;
  }

  /**
   * Get passwordHash
   *
   * @return passwordHash
   */
  @ApiModelProperty(required = true, value = "")
  @NotNull
  public String getPasswordHash() {
    return passwordHash;
  }

  public void setPasswordHash(String passwordHash) {
    this.passwordHash = passwordHash;
  }

  public Account lastLoginDate(Integer lastLoginDate) {
    this.lastLoginDate = lastLoginDate;
    return this;
  }

  /**
   * Get lastLoginDate
   *
   * @return lastLoginDate
   */
  @ApiModelProperty(example = "1647159287", value = "")
  public Integer getLastLoginDate() {
    return lastLoginDate;
  }

  public void setLastLoginDate(Integer lastLoginDate) {
    this.lastLoginDate = lastLoginDate;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Account account = (Account) o;
    return Objects.equals(this.id, account.id)
        && Objects.equals(this.username, account.username)
        && Objects.equals(this.passwordHash, account.passwordHash)
        && Objects.equals(this.lastLoginDate, account.lastLoginDate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, username, passwordHash, lastLoginDate);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Account {\n");

    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    username: ").append(toIndentedString(username)).append("\n");
    sb.append("    passwordHash: ").append(toIndentedString(passwordHash)).append("\n");
    sb.append("    lastLoginDate: ").append(toIndentedString(lastLoginDate)).append("\n");
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
