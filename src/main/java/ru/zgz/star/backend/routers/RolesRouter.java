package ru.zgz.star.backend.routers;

import com.google.gson.Gson;
import java.util.List;
import ru.zgz.star.backend.daos.RoleDao;
import ru.zgz.star.backend.exceptions.http.MethodNotAllowedException;
import ru.zgz.star.backend.models.Role;
import spark.Request;
import spark.Response;

/** Router, which handles requests to /roles. */
public class RolesRouter {

  /** Base path for all requests, which this router handles. */
  public static final String BASE_URL = "/roles";

  /**
   * Handles GET request to /roles.
   *
   * @param request request object
   * @param response response object
   * @return JSON representation of list of roles
   */
  public static String get(Request request, Response response) {
    response.type("application/json");
    RoleDao dao = new RoleDao();
    List<Role> roles = dao.getAll();
    return new Gson().toJson(roles);
  }

  /**
   * Handles POST request to /roles.
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
   * Handles PUT request to /roles.
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
   * Handles PATCH request to /roles.
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
   * Handles DELETE request to /roles.
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
}
