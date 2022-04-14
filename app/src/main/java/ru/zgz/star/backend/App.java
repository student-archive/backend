package ru.zgz.star.backend;

import io.github.cdimascio.dotenv.Dotenv;
import org.hibernate.cfg.Configuration;
import ru.zgz.star.backend.routes.AccountRouter;
import ru.zgz.star.backend.routes.EventPrioritiesRouter;
import ru.zgz.star.backend.routes.GetSoftwareRouter;

import static spark.Spark.get;

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

    get(AccountRouter.BASE_URL, AccountRouter::getExactAccount);
    get(EventPrioritiesRouter.BASE_URL, EventPrioritiesRouter::getPriorities);
    get(GetSoftwareRouter.BASE_URL, GetSoftwareRouter::getListSoftware);
  }
}
