package ru.zgz.star.backend.routers;

import com.google.gson.Gson;
import java.util.UUID;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.zgz.star.backend.daos.AccountDao;
import ru.zgz.star.backend.daos.EventDao;
import ru.zgz.star.backend.exceptions.http.BadRequestException;
import ru.zgz.star.backend.exceptions.http.MethodNotAllowedException;
import ru.zgz.star.backend.exceptions.http.ResourceNotFoundException;
import ru.zgz.star.backend.models.Account;
import ru.zgz.star.backend.models.Event;
import ru.zgz.star.backend.responses.DeletedResponse;
import ru.zgz.star.backend.util.ClassUtil;
import spark.Request;
import spark.Response;

/** Router, which handles requests to /event/:id. */
public class EventRouter {

  /** Base path for all requests, which this router handles. */
  public static String BASE_URL = "/event/:id";
  /** Logger for this class. */
  public static Logger logger = LoggerFactory.getLogger(EventRouter.class);

  /**
   * Handles GET request to /event/:id.
   *
   * @param request request object
   * @param response response object
   * @return JSON representation of exact account
   */
  public static String get(Request request, Response response) {
    response.type("application/json");
    EventDao dao = new EventDao();
    try {
      if (dao.findById(UUID.fromString(request.params("id")))) {
        Event event = dao.getById(request.params("id"));
        return new Gson().toJson(event);
      } else {
        response.status(404);
        throw new ResourceNotFoundException(
            String.format("Event id=%s not found", request.params("id")));
      }
    } catch (IllegalArgumentException e) {
      response.status(400);
      throw new BadRequestException(
          String.format("Given UUID (%s) is not valid", request.params("id")));
    }
  }

  /**
   * Handles DELETE request to /event/:id.
   *
   * @param request request object
   * @param response response object
   * @return JSON representation of id of deleted event
   */
  public static String delete(Request request, Response response) {
    response.type("application/json");
    EventDao dao = new EventDao();
    try {
      if (dao.findById(UUID.fromString(request.params("id")))) {
        dao.deleteById(UUID.fromString(request.params("id")));
        logger.info("Event {} deleted", request.params("id"));
        return new Gson().toJson(new DeletedResponse(UUID.fromString(request.params("id"))));
      } else {
        response.status(404);
        throw new ResourceNotFoundException(
            String.format("Event id=%s not found", request.params("id")));
      }
    } catch (IllegalArgumentException e) {
      response.status(400);
      throw new BadRequestException("Passed UUID is not valid");
    }
  }

  /**
   * Handles PATCH request to /event/:id.
   *
   * @param request request object
   * @param response response object
   * @return JSON representation of updated account
   */
  public static String patch(Request request, Response response) {
    response.type("application/json");
    EventDao dao = new EventDao();

    try {
      if (dao.findById(UUID.fromString(request.params("id")))) {
        logger.info("Event {} found", request.params("id"));
        Event event = dao.getById(request.params("id"));
        Event body = new Gson().fromJson(request.body(), Event.class);
        body.setId(event.getId());
        Event updated = (Event) ClassUtil.mergeObjects(body, event);
        dao.update(updated);
        return new Gson().toJson(updated);
      } else {
        response.status(404);
        throw new ResourceNotFoundException(
            String.format("Event id=%s not found", request.params("id")));
      }
    } catch (IllegalArgumentException e) {
      response.status(400);
      throw new BadRequestException("Passed UUID is not valid");
    }
  }

  /**
   * Handles PUT request to /event/:id.
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
   * Handles POST request to /event/:id.
   *
   * @param request request object
   * @param response response object
   * @return JSON representation of 405 error
   */
  public static String post(Request request, Response response) {
    response.type("application/json");
    response.status(405);
    throw new MethodNotAllowedException("Method POST is not allowed for this resource");
  }
}
