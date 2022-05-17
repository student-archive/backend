package ru.zgz.star.backend.routers;

import com.google.gson.Gson;
import java.util.UUID;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.zgz.star.backend.daos.AccountDao;
import ru.zgz.star.backend.daos.TutorDao;
import ru.zgz.star.backend.exceptions.http.BadRequestException;
import ru.zgz.star.backend.exceptions.http.MethodNotAllowedException;
import ru.zgz.star.backend.exceptions.http.ResourceNotFoundException;
import ru.zgz.star.backend.models.Account;
import ru.zgz.star.backend.models.Tutor;
import ru.zgz.star.backend.responses.DeletedResponse;
import ru.zgz.star.backend.util.ClassUtil;
import spark.Request;
import spark.Response;

/** Router, which handles requests to /tutor/:id. */
public class TutorRouter {

  /** Base path for all requests, which this router handles. */
  public static String BASE_URL = "/tutor/:id";
  /** Logger for this class. */
  public static Logger logger = LoggerFactory.getLogger(TutorRouter.class);

  /**
   * Handles GET request to /tutor/:id.
   *
   * @param request request object
   * @param response response object
   * @return JSON representation of exact tutor
   */
  public static String get(Request request, Response response) {
    response.type("application/json");
    TutorDao dao = new TutorDao();
    try {
      if (dao.findById(UUID.fromString(request.params("id")))) {
        Tutor tutor = dao.getById(request.params("id"));
        return new Gson().toJson(tutor);
      } else {
        response.status(404);
        throw new ResourceNotFoundException(
            String.format("Tutor id=%s not found", request.params("id")));
      }
    } catch (IllegalArgumentException e) {
      response.status(400);
      throw new BadRequestException(
          String.format("Given UUID (%s) is not valid", request.params("id")));
    }
  }

  /**
   * Handles DELETE request to /tutor/:id.
   *
   * @param request request object
   * @param response response object
   * @return JSON representation of id of deleted tutor
   */
  public static String delete(Request request, Response response) {
    response.type("application/json");
    TutorDao dao = new TutorDao();
    try {
      if (dao.findById(UUID.fromString(request.params("id")))) {
        dao.deleteById(UUID.fromString(request.params("id")));
        logger.info("Tutor {} deleted", request.params("id"));
        return new Gson().toJson(new DeletedResponse(UUID.fromString(request.params("id"))));
      } else {
        response.status(404);
        throw new ResourceNotFoundException(
            String.format("Tutor id=%s not found", request.params("id")));
      }
    } catch (IllegalArgumentException e) {
      response.status(400);
      throw new BadRequestException("Passed UUID is not valid");
    }
  }

  /**
   * Handles PATCH request to /tutor/:id.
   *
   * @param request request object
   * @param response response object
   * @return JSON representation of updated tutor
   */
  public static String patch(Request request, Response response) {
    response.type("application/json");
    TutorDao dao = new TutorDao();

    try {
      if (dao.findById(UUID.fromString(request.params("id")))) {
        logger.info("Tutor {} found", request.params("id"));
        Tutor tutor = dao.getById(request.params("id"));
        Tutor body = new Gson().fromJson(request.body(), Tutor.class);
        body.setId(tutor.getId());
        Tutor updated = (Tutor) ClassUtil.mergeObjects(body, tutor);
        dao.update(updated);
        return new Gson().toJson(updated);
      } else {
        response.status(404);
        throw new ResourceNotFoundException(
            String.format("Tutor id=%s not found", request.params("id")));
      }
    } catch (IllegalArgumentException e) {
      response.status(400);
      throw new BadRequestException("Passed UUID is not valid");
    }
  }

  /**
   * Handles PUT request to /tutor/:id.
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
   * Handles POST request to /tutor/:id.
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
