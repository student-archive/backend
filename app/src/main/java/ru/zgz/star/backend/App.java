package ru.zgz.star.backend;

import io.github.cdimascio.dotenv.Dotenv;
import org.hibernate.cfg.Configuration;
import ru.zgz.star.backend.routes.GetAccountRouter;
import ru.zgz.star.backend.routes.GetEventPrioritiesRouter;

import static spark.Spark.*;

/** Entry point of the application */
public class App {

  /**
   * Some test method to show how Spark works
   *
   * @return hello world string
   */
  public static String getGreeting() {
    return "Hello World";
  }

  /**
   * Executable method with definition of endpoints and connecting to database
   *
   * @param args Command-line arguments
   */
  public static void main(String[] args) {
    Configuration cfg = new Configuration();
    Dotenv dotenv = Dotenv.load();
    cfg.setProperty("hibernate.connection.url", dotenv.get("DATABASE_URL"));

    get(GetAccountRouter.BASE_URL + "/:id", GetAccountRouter::getExactAccount);
    get(GetEventPrioritiesRouter.BASE_URL, GetEventPrioritiesRouter::getPriorities);
  }
}
