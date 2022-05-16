package ru.zgz.star.backend.routers;

import com.google.gson.Gson;
import java.util.UUID;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.zgz.star.backend.daos.QuestionDao;
import ru.zgz.star.backend.daos.TrashDao;
import ru.zgz.star.backend.exceptions.http.BadRequestException;
import ru.zgz.star.backend.exceptions.http.MethodNotAllowedException;
import ru.zgz.star.backend.exceptions.http.ResourceNotFoundException;
import ru.zgz.star.backend.models.Question;
import ru.zgz.star.backend.models.Trash;
import ru.zgz.star.backend.responses.DeletedResponse;
import ru.zgz.star.backend.util.ClassUtil;
import spark.Request;
import spark.Response;

/** Router, which handles requests to /trash/:id. */
public class TrashRouter {

  /** Base path for all requests, which this router handles. */
  public static String BASE_URL = "/trash/:id";
  /** Logger for this class. */
  public static Logger logger = LoggerFactory.getLogger(TrashRouter.class);

  /**
   * Handles GET request to /trash/:id.
   *
   * @param request request object
   * @param response response object
   * @return JSON representation of exact quiz
   */
  public static String get(Request request, Response response) {
    response.type("application/json");
    TrashDao dao = new TrashDao();
    try {
      if (dao.findById(UUID.fromString(request.params("id")))) {
        Trash trash = dao.getById(request.params("id"));
        return new Gson().toJson(trash);
      } else {
        response.status(404);
        throw new ResourceNotFoundException(
            String.format("Trash id=%s not found", request.params("id")));
      }
    } catch (IllegalArgumentException e) {
      response.status(400);
      throw new BadRequestException(
          String.format("Given UUID (%s) is not valid", request.params("id")));
    }
  }

  /**
   * Handles DELETE request to /trash/:id.
   *
   * @param request request object
   * @param response response object
   * @return JSON representation of id of deleted quiz
   */
  public static String delete(Request request, Response response) {
    response.type("application/json");
    TrashDao dao = new TrashDao();
    try {
      if (dao.findById(UUID.fromString(request.params("id")))) {
        dao.deleteById(UUID.fromString(request.params("id")));
        logger.info("Trash {} deleted", request.params("id"));
        return new Gson().toJson(new DeletedResponse(UUID.fromString(request.params("id"))));
      } else {
        response.status(404);
        throw new ResourceNotFoundException(
            String.format("Trash id=%s not found", request.params("id")));
      }
    } catch (IllegalArgumentException e) {
      response.status(400);
      throw new BadRequestException("Passed UUID is not valid");
    }
  }

  /**
   * Handles PATCH request to /trash/:id.
   *
   * @param request request object
   * @param response response object
   * @return JSON representation of 405 error
   */
  public static String patch(Request request, Response response) {
    response.type("application/json");
    response.status(405);
    throw new MethodNotAllowedException("Method PATCH is not allowed for this resource");
  }


  /**
   * Handles PUT request to /trash/:id.
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
   * Handles POST request to /trash/:id.
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
