package ru.zgz.star.backend.routers;

import com.google.gson.Gson;
import java.util.UUID;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.zgz.star.backend.daos.UserDao;
import ru.zgz.star.backend.exceptions.http.BadRequestException;
import ru.zgz.star.backend.exceptions.http.MethodNotAllowedException;
import ru.zgz.star.backend.exceptions.http.ResourceNotFoundException;
import ru.zgz.star.backend.models.User;
import ru.zgz.star.backend.util.ClassUtil;
import spark.Request;
import spark.Response;

/** Router, which handles requests to /user/:id. */
public class UserRouter {

  /** Base path for all requests, which this router handles. */
  public static String BASE_URL = "/user/:id";
  /** Logger for this class. */
  public static Logger logger = LoggerFactory.getLogger(UserRouter.class);

  /**
   * Handles GET request to /user/:id.
   *
   * @param request request object
   * @param response response object
   * @return JSON representation of exact user
   */
  public static String get(Request request, Response response) {
    response.type("application/json");
    UserDao dao = new UserDao();
    try {
      if (dao.findById(UUID.fromString(request.params("id")))) {
        User user = dao.getById(request.params("id"));
        return new Gson().toJson(user);
      } else {
        response.status(404);
        throw new ResourceNotFoundException(
            String.format("Account id=%s not found", request.params("id")));
      }
    } catch (IllegalArgumentException e) {
      response.status(400);
      throw new BadRequestException(
          String.format("Given UUID (%s) is not valid", request.params("id")));
    }
  }

  /**
   * Handles Delete request to /user/:id.
   *
   * @param request request object
   * @param response response object
   * @return JSON representation of 405 error
   */
  public static String delete(Request request, Response response) {
    response.type("application/json");
    response.status(405);
    throw new MethodNotAllowedException("Method DELETE is not allowed for this resource");
  }

  /**
   * Handles PATCH request to /user/:id.
   *
   * @param request request object
   * @param response response object
   * @return JSON representation of updated user
   */
  public static String patch(Request request, Response response) {
    response.type("application/json");
    UserDao dao = new UserDao();

    try {
      if (dao.findById(UUID.fromString(request.params("id")))) {
        logger.info("User {} found", request.params("id"));
        User user = dao.getById(request.params("id"));
        User body = new Gson().fromJson(request.body(), User.class);
        body.setId(user.getId());
        User updated = (User) ClassUtil.mergeObjects(body, user);
        dao.update(updated);
        return new Gson().toJson(updated);
      } else {
        response.status(404);
        throw new ResourceNotFoundException(
            String.format("User id=%s not found", request.params("id")));
      }
    } catch (IllegalArgumentException e) {
      response.status(400);
      throw new BadRequestException("Passed UUID is not valid");
    }
  }

  /**
   * Handles PUT request to /user/:id.
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
   * Handles POST request to /user/:id.
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
