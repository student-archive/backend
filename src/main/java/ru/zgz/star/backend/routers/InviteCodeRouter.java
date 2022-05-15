package ru.zgz.star.backend.routers;

import com.google.gson.Gson;
import java.util.UUID;
import ru.zgz.star.backend.daos.InviteCodeDao;
import ru.zgz.star.backend.exceptions.http.BadRequestException;
import ru.zgz.star.backend.exceptions.http.MethodNotAllowedException;
import ru.zgz.star.backend.exceptions.http.ResourceNotFoundException;
import ru.zgz.star.backend.models.InviteCode;
import ru.zgz.star.backend.responses.DeletedResponse;
import spark.Request;
import spark.Response;

/** Router, which handles requests to /inviteCode/:id. */
public class InviteCodeRouter {

  /** Base path for all requests, which this router handles. */
  public static final String BASE_URL = "/inviteCode/:id";

  /**
   * Handles GET request to /inviteCode/:id.
   *
   * @param request request object
   * @param response response object
   * @return JSON representation of exact account
   */
  public static String get(Request request, Response response) {
    response.type("application/json");
    InviteCodeDao dao = new InviteCodeDao();
    try {
      if (dao.findById(UUID.fromString(request.params("id")))) {
        InviteCode inviteCode = dao.getById(request.params("id"));
        return new Gson().toJson(inviteCode);
      } else {
        response.status(404);
        throw new ResourceNotFoundException(
            String.format("InviteCode id=%s not found", request.params("id")));
      }
    } catch (IllegalArgumentException e) {
      response.status(400);
      throw new BadRequestException(
          String.format("Given UUID (%s) is not valid", request.params("id")));
    }
  }

  /**
   * Handles DELETE request to /inviteCode/:id.
   *
   * @param request request object
   * @param response response object
   * @return JSON representation of id of deleted account
   */
  public static String delete(Request request, Response response) {
    response.type("application/json");
    InviteCodeDao dao = new InviteCodeDao();
    try {
      if (dao.findById(UUID.fromString(request.params("id")))) {
        dao.deleteById(UUID.fromString(request.params("id")));
        return new Gson().toJson(new DeletedResponse(UUID.fromString(request.params("id"))));
      } else {
        response.status(404);
        throw new ResourceNotFoundException(
            String.format("InviteCode id=%s not found", request.params("id")));
      }
    } catch (IllegalArgumentException e) {
      response.status(400);
      throw new BadRequestException(
          String.format("Given UUID (%s) is not valid", request.params("id")));
    }
  }

  /**
   * Handles POST request to /account/:id.
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

  /**
   * Handles PUT request to /account/:id.
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
   * Handles PATCH request to /account/:id.
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
}
