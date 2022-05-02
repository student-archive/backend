package ru.zgz.star.backend;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

  public static Logger logger = LoggerFactory.getLogger(App.class);

  /**
   * Executable method with definition of endpoints.
   *
   * <p>Automatically collects created methods by correct HTTP verbs
   *
   * @param args Command-line arguments
   */
  public static void main(String[] args)
      throws IOException, NoSuchFieldException, IllegalAccessException {

    get("/ping", (req, res) -> "pong");

    for (Class<?> cls : ClassUtil.findAllClasses("ru.zgz.star.backend.routes")) {
      logger.info("Found class: {}", cls.getName());
      String basePath = (String) cls.getField("BASE_URL").get(cls);
      for (Method method : cls.getDeclaredMethods()) {
        logger.info(
            "Registering endpoint: {}.{} by path {}",
            cls.getSimpleName(),
            method.getName(),
            basePath);
        if (method.getName().startsWith("get")) {
          get(
              basePath,
              (req, res) -> method.invoke(cls.getDeclaredConstructor().newInstance(), req, res));
        } else if (method.getName().startsWith("post")) {
          post(
              basePath,
              (req, res) -> method.invoke(cls.getDeclaredConstructor().newInstance(), req, res));
        } else if (method.getName().startsWith("patch")) {
          patch(
              basePath,
              (req, res) -> method.invoke(cls.getDeclaredConstructor().newInstance(), req, res));
        } else if (method.getName().startsWith("put")) {
          put(
              basePath,
              (req, res) -> method.invoke(cls.getDeclaredConstructor().newInstance(), req, res));
        } else if (method.getName().startsWith("delete")) {
          delete(
              basePath,
              (req, res) -> method.invoke(cls.getDeclaredConstructor().newInstance(), req, res));
        } else {
          stop();
          throw new IllegalArgumentException(
              "Method " + method.getName() + "in class " + cls + " is not supported");
        }
      }
      internalServerError((req, res) -> {
        res.type("application/json");
        return "{\"message\":\"Internal server error\"}";
      });
    }
  }
}
