package ru.giv.star.backend.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import ru.giv.star.backend.models.Account;
import org.openapitools.jackson.nullable.JsonNullable;
import javax.validation.Valid;
import javax.validation.constraints.*;

/** Unique one-time code to add new users */
@ApiModel(description = "Unique one-time code to add new users")
@javax.annotation.Generated(
    value = "org.openapitools.codegen.languages.SpringCodegen",
    date = "2022-03-17T11:30:21.915317900+03:00[Europe/Moscow]")
public class InviteCode {
  @JsonProperty("id")
  private String id;

  @JsonProperty("account")
  private Account account;

  @JsonProperty("inviteCode")
  private String inviteCode;

  @JsonProperty("isValid")
  private Boolean isValid = true;

  @JsonProperty("activatedDate")
  private Integer activatedDate;

  public InviteCode id(String id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   *
   * @return id
   */
  @ApiModelProperty(example = "c02221c7-f761-4680-a414-8eb49984e138", required = true, value = "")
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

  public InviteCode account(Account account) {
    this.account = account;
    return this;
  }

  /**
   * Get account
   *
   * @return account
   */
  @ApiModelProperty(value = "")
  @Valid
  public Account getAccount() {
    return account;
  }

  public void setAccount(Account account) {
    this.account = account;
  }

  public InviteCode inviteCode(String inviteCode) {
    this.inviteCode = inviteCode;
    return this;
  }

  /**
   * Get inviteCode
   *
   * @return inviteCode
   */
  @ApiModelProperty(required = true, value = "")
  @NotNull
  public String getInviteCode() {
    return inviteCode;
  }

  public void setInviteCode(String inviteCode) {
    this.inviteCode = inviteCode;
  }

  public InviteCode isValid(Boolean isValid) {
    this.isValid = isValid;
    return this;
  }

  /**
   * Get isValid
   *
   * @return isValid
   */
  @ApiModelProperty(required = true, value = "")
  @NotNull
  public Boolean getIsValid() {
    return isValid;
  }

  public void setIsValid(Boolean isValid) {
    this.isValid = isValid;
  }

  public InviteCode activatedDate(Integer activatedDate) {
    this.activatedDate = activatedDate;
    return this;
  }

  /**
   * Get activatedDate
   *
   * @return activatedDate
   */
  @ApiModelProperty(example = "1647159287", value = "")
  public Integer getActivatedDate() {
    return activatedDate;
  }

  public void setActivatedDate(Integer activatedDate) {
    this.activatedDate = activatedDate;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    InviteCode inviteCode = (InviteCode) o;
    return Objects.equals(this.id, inviteCode.id)
        && Objects.equals(this.account, inviteCode.account)
        && Objects.equals(this.inviteCode, inviteCode.inviteCode)
        && Objects.equals(this.isValid, inviteCode.isValid)
        && Objects.equals(this.activatedDate, inviteCode.activatedDate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, account, inviteCode, isValid, activatedDate);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class InviteCode {\n");

    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    account: ").append(toIndentedString(account)).append("\n");
    sb.append("    inviteCode: ").append(toIndentedString(inviteCode)).append("\n");
    sb.append("    isValid: ").append(toIndentedString(isValid)).append("\n");
    sb.append("    activatedDate: ").append(toIndentedString(activatedDate)).append("\n");
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
