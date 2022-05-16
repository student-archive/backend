package ru.zgz.star.backend.routers;

import com.google.gson.Gson;
import java.util.List;
import java.util.UUID;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.zgz.star.backend.daos.EventDao;
import ru.zgz.star.backend.daos.UserDao;
import ru.zgz.star.backend.exceptions.http.BadRequestException;
import ru.zgz.star.backend.exceptions.http.MethodNotAllowedException;
import ru.zgz.star.backend.exceptions.http.ResourceNotFoundException;
import ru.zgz.star.backend.models.Event;
import spark.Request;
import spark.Response;

/** Router, which handles requests to /events/byUser/:user. */
public class EventsByUserRouter {

  /** Base path for all requests, which this router handles. */
  public static String BASE_URL = "/events/byUser/:user";
  /** Logger for this class. */
  public static Logger logger = LoggerFactory.getLogger(EventsByUserRouter.class);

  /**
   * Handles GET request to /events/byUser/:user.
   *
   * @param request request object
   * @param response response object
   * @return JSON representation of all events of user
   */
  public static String get(Request request, Response response) {
    response.type("application/json");
    EventDao eventDao = new EventDao();
    UserDao userDao = new UserDao();
    try {
      if (userDao.findById(UUID.fromString(request.params("user")))) {
        List<Event> events = eventDao.getByUser(request.params("user"));
        return new Gson().toJson(events);
      } else {
        response.status(404);
        throw new ResourceNotFoundException(
            String.format("User id=%s not found", request.params("user")));
      }
    } catch (IllegalArgumentException e) {
      response.status(400);
      throw new BadRequestException(
          String.format("Given UUID (%s) is not valid", request.params("user")));
    }
  }

  /**
   * Handles DELETE requests to /events/byUser/:user.
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
   * Handles PATCH requests to /events/byUser/:user.
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
   * Handles PUT request to /events/byUser/:user.
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
   * Handles POST request to /events/byUser/:user.
   *
   * @param request request object
   * @param response response object
   * @return JSON representation of 405 error
   */
  public static String post(Request request, Response response) {
    response.type("application/json");
    response.status(405);
    throw new MethodNotAllowedException("Method DELETE is not allowed for this resource");
  }
}
