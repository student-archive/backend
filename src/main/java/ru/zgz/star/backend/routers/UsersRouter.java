package ru.zgz.star.backend.routers;

import com.google.gson.Gson;
import ru.zgz.star.backend.daos.UserDao;
import ru.zgz.star.backend.exceptions.http.MethodNotAllowedException;
import ru.zgz.star.backend.models.User;
import spark.Request;
import spark.Response;

/** Router, which handles requests to /users. */
public class UsersRouter {
  /** Base path for all requests, which this router handles. */
  public static final String BASE_URL = "/users";

  /**
   * Handles GET requests to /users.
   *
   * @param request request object
   * @param response response object
   * @return JSON representation of the 405 error
   */
  public static String get(Request request, Response response) {
    response.type("application/json");
    response.status(405);
    throw new MethodNotAllowedException("Method get is not allowed for this resource");
  }

  /**
   * Handles POST requests to /users.
   *
   * @param request request object
   * @param response response object
   * @return JSON representation of the created account
   */
  public static String post(Request request, Response response) {
    response.type("application/json");
    response.status(201);
    UserDao dao = new UserDao();
    User user = new Gson().fromJson(request.body(), User.class);
    dao.add(user);
    return new Gson().toJson(user);
  }

  /**
   * Handles PATCH requests to /users.
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
   * Handles DELETE requests to /users.
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
   * Handles PUT requests to /users.
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
