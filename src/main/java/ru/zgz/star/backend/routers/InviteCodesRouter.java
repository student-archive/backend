package ru.zgz.star.backend.routers;

import com.google.gson.Gson;
import ru.zgz.star.backend.daos.InviteCodeDao;
import ru.zgz.star.backend.exceptions.http.MethodNotAllowedException;
import ru.zgz.star.backend.models.InviteCode;
import spark.Request;
import spark.Response;

/** Router, which handles requests to /inviteCodes. */
public class InviteCodesRouter {

  /** Base path for all requests, which this router handles. */
  public static final String BASE_URL = "/inviteCodes";

  /**
   * Handles GET requests to /inviteCodes.
   *
   * @param request request object
   * @param response response object
   * @return JSON representation of the created invite code
   */
  public static String get(Request request, Response response) {
    response.type("application/json");
    response.status(405);
    throw new MethodNotAllowedException("Method GET is not allowed for this resource");
  }

  /**
   * Handles POST requests to /inviteCodes.
   *
   * @param request request object
   * @param response response object
   * @return JSON representation of the created invite code
   */
  public static String post(Request request, Response response) {
    try {
      response.type("application/json");
      response.status(201);
      InviteCodeDao inviteCodeDao = new InviteCodeDao();
      InviteCode inviteCode = new Gson().fromJson(request.body(), InviteCode.class);
      inviteCodeDao.add(inviteCode);
      return new Gson().toJson(inviteCode);
    } catch (Exception e) {
      response.status(500);
      throw e;
    }
  }

  /**
   * Handles PUT requests to /inviteCodes.
   *
   * @param request request object
   * @param response response object
   * @return JSON representation of the created invite code
   */
  public static String put(Request request, Response response) {
    response.type("application/json");
    response.status(405);
    throw new MethodNotAllowedException("Method PUT is not allowed for this resource");
  }

  /**
   * Handles PATCH requests to /inviteCodes.
   *
   * @param request request object
   * @param response response object
   * @return JSON representation of the created invite code
   */
  public static String patch(Request request, Response response) {
    response.type("application/json");
    response.status(405);
    throw new MethodNotAllowedException("Method PATCH is not allowed for this resource");
  }

  /**
   * Handles DELETE requests to /inviteCodes.
   *
   * @param request request object
   * @param response response object
   * @return JSON representation of the created invite code
   */
  public static String delete(Request request, Response response) {
    response.type("application/json");
    response.status(405);
    throw new MethodNotAllowedException("Method DELETE is not allowed for this resource");
  }
}
