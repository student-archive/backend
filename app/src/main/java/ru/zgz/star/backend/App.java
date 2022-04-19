package ru.zgz.star.backend;

import ru.zgz.star.backend.routes.AccountRouter;
import ru.zgz.star.backend.routes.EventPrioritiesRouter;
import ru.zgz.star.backend.routes.GetSoftwareRouter;

import static spark.Spark.get;

/** Entry point of the application */
public class App {

  /**
   * Executable method with definition of endpoints
   *
   * @param args Command-line arguments
   */
  public static void main(String[] args) {
    get(AccountRouter.BASE_URL, AccountRouter::getExactAccount);
    get(EventPrioritiesRouter.BASE_URL, EventPrioritiesRouter::getPriorities);
    get(GetSoftwareRouter.BASE_URL, GetSoftwareRouter::getListSoftware);
  }
}
