package ru.giv.star.backend.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Objects;

/** Answers of the question */
@ApiModel(description = "Answers of the question")
@javax.annotation.Generated(
    value = "org.openapitools.codegen.languages.SpringCodegen",
    date = "2022-03-17T11:30:21.915317900+03:00[Europe/Moscow]")
public class QuizVariant {
  @JsonProperty("id")
  private String id;

  @JsonProperty("quizVariantText")
  private String quizVariantText;

  @JsonProperty("isCorrect")
  private Boolean isCorrect;

  public QuizVariant id(String id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   *
   * @return id
   */
  @ApiModelProperty(example = "e13764a2-938a-4bfe-98e4-d6b0de0006ec", required = true, value = "")
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

  public QuizVariant quizVariantText(String quizVariantText) {
    this.quizVariantText = quizVariantText;
    return this;
  }

  /**
   * Get quizVariantText
   *
   * @return quizVariantText
   */
  @ApiModelProperty(required = true, value = "")
  @NotNull
  public String getQuizVariantText() {
    return quizVariantText;
  }

  public void setQuizVariantText(String quizVariantText) {
    this.quizVariantText = quizVariantText;
  }

  public QuizVariant isCorrect(Boolean isCorrect) {
    this.isCorrect = isCorrect;
    return this;
  }

  /**
   * Get isCorrect
   *
   * @return isCorrect
   */
  @ApiModelProperty(required = true, value = "")
  @NotNull
  public Boolean getIsCorrect() {
    return isCorrect;
  }

  public void setIsCorrect(Boolean isCorrect) {
    this.isCorrect = isCorrect;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    QuizVariant quizVariant = (QuizVariant) o;
    return Objects.equals(this.id, quizVariant.id)
        && Objects.equals(this.quizVariantText, quizVariant.quizVariantText)
        && Objects.equals(this.isCorrect, quizVariant.isCorrect);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, quizVariantText, isCorrect);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class QuizVariant {\n");

    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    quizVariantText: ").append(toIndentedString(quizVariantText)).append("\n");
    sb.append("    isCorrect: ").append(toIndentedString(isCorrect)).append("\n");
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
