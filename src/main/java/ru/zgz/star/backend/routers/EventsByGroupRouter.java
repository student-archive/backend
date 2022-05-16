package ru.zgz.star.backend.routers;

import com.google.gson.Gson;
import java.util.List;
import java.util.UUID;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.zgz.star.backend.daos.EventDao;
import ru.zgz.star.backend.daos.GroupDao;
import ru.zgz.star.backend.exceptions.http.BadRequestException;
import ru.zgz.star.backend.exceptions.http.MethodNotAllowedException;
import ru.zgz.star.backend.exceptions.http.ResourceNotFoundException;
import ru.zgz.star.backend.models.Event;
import spark.Request;
import spark.Response;

/** Router, which handles requests to /events/byGroup/:group. */
public class EventsByGroupRouter {

  /** Base path for all requests, which this router handles. */
  public static String BASE_URL = "/events/byGroup/:group";
  /** Logger for this class. */
  public static Logger logger = LoggerFactory.getLogger(EventsByGroupRouter.class);

  /**
   * Handles GET request to /events/byGroup/:group.
   *
   * @param request request object
   * @param response response object
   * @return JSON representation of all events of group
   */
  public static String get(Request request, Response response) {
    response.type("application/json");
    EventDao eventDao = new EventDao();
    GroupDao groupDao = new GroupDao();
    try {
      if (groupDao.findById(UUID.fromString(request.params("group")))) {
        List<Event> events = eventDao.getByGroup(request.params("group"));
        return new Gson().toJson(events);
      } else {
        response.status(404);
        throw new ResourceNotFoundException(
            String.format("Group id=%s not found", request.params("group")));
      }
    } catch (IllegalArgumentException e) {
      response.status(400);
      throw new BadRequestException(
          String.format("Given UUID (%s) is not valid", request.params("group")));
    }
  }

  /**
   * Handles DELETE requests to /events/byGroup/:group.
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
   * Handles PATCH requests to /events/byGroup/:group.
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
   * Handles PUT request to/events/byGroup/:group.
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
   * Handles POST request to /events/byGroup/:group.
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
