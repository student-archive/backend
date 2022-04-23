package ru.zgz.star.backend;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.tags.Tag;
import ru.zgz.star.backend.util.ClassUtil;

import java.io.IOException;
import java.lang.reflect.Method;

import static spark.Spark.*;

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
  public static void main(String[] args) throws IOException, NoSuchFieldException {
    for (Class<?> cls : ClassUtil.findAllClasses("ru.zgz.star.backend.routers")) {
      for (Method method : cls.getDeclaredMethods()) {
        if (method.getName().startsWith("get")) {
          get(cls.getDeclaredField("BASE_URL").toString(), method::invoke);
        } else if (method.getName().startsWith("post")) {
          post(cls.getDeclaredField("BASE_URL").toString(), method::invoke);
        } else if (method.getName().startsWith("patch")) {
          patch(cls.getDeclaredField("BASE_URL").toString(), method::invoke);
        } else if (method.getName().startsWith("put")) {
          put(cls.getDeclaredField("BASE_URL").toString(), method::invoke);
        } else if (method.getName().startsWith("delete")) {
          delete(cls.getDeclaredField("BASE_URL").toString(), method::invoke);
        } else {
          throw new IllegalArgumentException(
              "Method " + method.getName() + "in class " + cls + " is not supported");
        }
      }
    }
  }
}
