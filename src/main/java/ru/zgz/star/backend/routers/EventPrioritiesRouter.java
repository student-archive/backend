package ru.zgz.star.backend.routers;

import com.google.gson.Gson;
import ru.zgz.star.backend.daos.EventPriorityDao;
import ru.zgz.star.backend.exceptions.http.MethodNotAllowedException;
import spark.Request;
import spark.Response;

/** Router, which handles requests to /eventPriorities. */
public class EventPrioritiesRouter {
  /** Base path for all requests, which this router handles. */
  public static final String BASE_URL = "/eventPriorities";

  /**
   * Handles GET requests to /eventPriorities.
   *
   * @param request request object
   * @param response response object
   * @return JSON representation of all accounts
   */
  public static String get(Request request, Response response) {
    response.type("application/json");
    EventPriorityDao dao = new EventPriorityDao();
    return new Gson().toJson(dao.getAll());
  }

  /**
   * Handles POST requests to /eventPriorities.
   *
   * @param request request object
   * @param response response object
   * @return JSON representation of the 405 error
   */
  public static String post(Request request, Response response) {
    response.type("application/json");
    response.status(405);
    throw new MethodNotAllowedException("Method post is not allowed for this resource");
  }

  /**
   * Handles PATCH requests to /eventPriorities.
   *
   * @param request request object
   * @param response response object
   * @return JSON representation of the 405 error
   */
  public static String patch(Request request, Response response) {
    response.type("application/json");
    response.status(405);
    throw new MethodNotAllowedException("Method PATCH is not allowed for this resource");
  }

  /**
   * Handles DELETE requests to /eventPriorities.
   *
   * @param request request object
   * @param response response object
   * @return JSON representation of the 405 error
   */
  public static String delete(Request request, Response response) {
    response.type("application/json");
    response.status(405);
    throw new MethodNotAllowedException("Method DELETE is not allowed for this resource");
  }

  /**
   * Handles PUT requests to /eventPriorities.
   *
   * @param request request object
   * @param response response object
   * @return JSON representation of the 405 error
   */
  public static String put(Request request, Response response) {
    response.type("application/json");
    response.status(405);
    throw new MethodNotAllowedException("Method PUT is not allowed for this resource");
  }
}
