package ru.zgz.star.backend;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.tags.Tag;

@OpenAPIDefinition(
    info =
        @Info(
            title = "Star Backend",
            version = "0.0.1",
            contact = @Contact(name = "ZGZ Team", email = "dadyarri@gmail.com"),
            license =
                @License(
                    name = "MIT",
                    url = "https://github.com/student-archive/backend/blob/master/LICENSE.txt")),
    tags = {
      @Tag(name = "persons", description = "Operations about persons"),
      @Tag(name = "quizzes", description = "Operations about quizzes"),
      @Tag(name = "content", description = "Operations about content"),
    })
public class App {

  /**
   * Executable method with definition of endpoints
   *
   * @param args Command-line arguments
   */
  public static void main(String[] args) {
  }
}
