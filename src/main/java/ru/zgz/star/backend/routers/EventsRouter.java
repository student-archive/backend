package ru.zgz.star.backend.routers;

import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.zgz.star.backend.daos.EventDao;
import ru.zgz.star.backend.exceptions.http.MethodNotAllowedException;
import ru.zgz.star.backend.models.Event;
import spark.Request;
import spark.Response;

/** Router, which handles requests to /events. */
public class EventsRouter {

  /** Base path for all requests, which this router handles. */
  public static String BASE_URL = "/events/byGroup/:group";
  /** Logger for this class. */
  public static Logger logger = LoggerFactory.getLogger(EventsRouter.class);

  /**
   * Handles GET request to /events.
   *
   * @param request request object
   * @param response response object
   * @return JSON representation of the 405 error
   */
  public static String get(Request request, Response response) {
    response.type("application/json");
    response.status(405);
    throw new MethodNotAllowedException("Method DELETE is not allowed for this resource");
  }

  /**
   * Handles DELETE requests to /events.
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
   * Handles PATCH requests to /events.
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
   * Handles PUT request to/events.
   *
   * @param request request object
   * @param response response object
   * @return JSON representation of 405 error
   */
  public static String put(Request request, Response response) {
    response.type("application/json");
    response.status(405);
    throw new MethodNotAllowedException("Method PUT is not allowed for this resource");
  }

  /**
   * Handles POST request to /events.
   *
   * @param request request object
   * @param response response object
   * @return JSON representation of 405 error
   */
  public static String post(Request request, Response response) {
    try {
      response.type("application/json");
      response.status(201);
      EventDao dao = new EventDao();
      Event event = new Gson().fromJson(request.body(), Event.class);
      dao.add(event);
      return new Gson().toJson(event);
    } catch (Exception e) {
      response.status(500);
      throw e;
    }
  }
}
