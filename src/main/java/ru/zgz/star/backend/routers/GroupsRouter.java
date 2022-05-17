package ru.zgz.star.backend.routers;

import com.google.gson.Gson;
import ru.zgz.star.backend.daos.GroupDao;
import ru.zgz.star.backend.exceptions.http.MethodNotAllowedException;
import ru.zgz.star.backend.models.Group;
import spark.Request;
import spark.Response;

/** Router, which handles requests to /groups. */
public class GroupsRouter {
  /** Base path for all requests, which this router handles. */
  public static final String BASE_URL = "/groups";

  /**
   * Handles GET requests to /groups.
   *
   * @param request request object
   * @param response response object
   * @return JSON representation of all groups
   */
  public static String get(Request request, Response response) {
    response.type("application/json");
    GroupDao dao = new GroupDao();
    return new Gson().toJson(dao.getAll());
  }

  /**
   * Handles POST requests to /groups.
   *
   * @param request request object
   * @param response response object
   * @return JSON representation of the created group
   */
  public static String post(Request request, Response response) {
    try {
      response.type("application/json");
      response.status(201);
      GroupDao dao = new GroupDao();
      Group group = new Gson().fromJson(request.body(), Group.class);
      dao.add(group);
      return new Gson().toJson(group);
    } catch (Exception e) {
      response.status(500);
      throw e;
    }
  }

  /**
   * Handles PATCH requests to /groups.
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
   * Handles DELETE requests to /groups.
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
   * Handles PUT requests to /groups.
   *
   * @param request request object
   * @param response response object
   * @return JSON representation of the 405 error
   */
  public static String put(Request request, Response response) {
    response.type("application/json");
    response.status(405);
    throw new MethodNotAllowedException("Method PUT is not allowed for this resource");
  }
}
