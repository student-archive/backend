package ru.zgz.star.backend;

import static spark.Spark.delete;
import static spark.Spark.exception;
import static spark.Spark.get;
import static spark.Spark.patch;
import static spark.Spark.post;
import static spark.Spark.put;
import static spark.Spark.stop;

import com.google.gson.Gson;
import java.io.IOException;
import java.lang.reflect.Method;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.zgz.star.backend.exceptions.http.BaseHttpException;
import ru.zgz.star.backend.responses.ErrorResponse;
import ru.zgz.star.backend.util.ClassUtil;

/** Main class of the application. */
public class App {

  /** Logger object of the class. */
  public static Logger logger = LoggerFactory.getLogger(App.class);

  /**
   * Executable method with definition of endpoints.
   *
   * <p>Automatically collects created methods by correct HTTP verbs
   *
   * @param args Command-line arguments
   * @throws IOException If an I/O error occurs
   * @throws NoSuchFieldException If a class cannot be found
   * @throws IllegalAccessException If a class is not accessible
   */
  public static void main(String[] args)
      throws IOException, NoSuchFieldException, IllegalAccessException {

    get("/ping", (req, res) -> "pong");

    for (Class<?> cls : ClassUtil.findAllClasses("ru.zgz.star.backend.routers")) {
      logger.info("Found class: {}", cls.getName());
      String basePath = (String) cls.getField("BASE_URL").get(cls);
      for (Method method : cls.getDeclaredMethods()) {
        logger.info(
            "    Registering endpoint: {}.{} by path {} as {}",
            cls.getSimpleName(),
            method.getName(),
            basePath,
            method.getName().toUpperCase());
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
      exception(
          BaseHttpException.class,
          (ex, req, res) -> {
            res.type("application/json");
            res.body(
                new Gson()
                    .toJson(
                        new ErrorResponse(
                            res.status(),
                            ex.getCause().getMessage(),
                            ex.getCause().getClass().getSimpleName())));
          });
    }
  }
}
