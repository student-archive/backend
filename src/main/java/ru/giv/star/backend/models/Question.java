package ru.giv.star.backend.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import ru.giv.star.backend.models.QuizVariant;
import org.openapitools.jackson.nullable.JsonNullable;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * The component of the test
 */
@ApiModel(description = "The component of the test")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-03-17T11:30:21.915317900+03:00[Europe/Moscow]")
public class Question   {
  @JsonProperty("id")
  private String id;

  @JsonProperty("questionText")
  private String questionText;

  @JsonProperty("questionDescription")
  private String questionDescription;

  @JsonProperty("variants")
  @Valid
  private List<QuizVariant> variants = new ArrayList<>();

  public Question id(String id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
  */
  @ApiModelProperty(example = "a8f63983-99a9-4c2d-a5fd-3fd7d4839ba9", required = true, value = "")
  @NotNull

@Pattern(regexp="^[0-9a-fA-F]{8}\\b-[0-9a-fA-F]{4}\\b-[0-9a-fA-F]{4}\\b-[0-9a-fA-F]{4}\\b-[0-9a-fA-F]{12}$") 
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public Question questionText(String questionText) {
    this.questionText = questionText;
    return this;
  }

  /**
   * Get questionText
   * @return questionText
  */
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public String getQuestionText() {
    return questionText;
  }

  public void setQuestionText(String questionText) {
    this.questionText = questionText;
  }

  public Question questionDescription(String questionDescription) {
    this.questionDescription = questionDescription;
    return this;
  }

  /**
   * Get questionDescription
   * @return questionDescription
  */
  @ApiModelProperty(value = "")


  public String getQuestionDescription() {
    return questionDescription;
  }

  public void setQuestionDescription(String questionDescription) {
    this.questionDescription = questionDescription;
  }

  public Question variants(List<QuizVariant> variants) {
    this.variants = variants;
    return this;
  }

  public Question addVariantsItem(QuizVariant variantsItem) {
    this.variants.add(variantsItem);
    return this;
  }

  /**
   * Get variants
   * @return variants
  */
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @Valid

  public List<QuizVariant> getVariants() {
    return variants;
  }

  public void setVariants(List<QuizVariant> variants) {
    this.variants = variants;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Question question = (Question) o;
    return Objects.equals(this.id, question.id) &&
        Objects.equals(this.questionText, question.questionText) &&
        Objects.equals(this.questionDescription, question.questionDescription) &&
        Objects.equals(this.variants, question.variants);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, questionText, questionDescription, variants);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Question {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    questionText: ").append(toIndentedString(questionText)).append("\n");
    sb.append("    questionDescription: ").append(toIndentedString(questionDescription)).append("\n");
    sb.append("    variants: ").append(toIndentedString(variants)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

