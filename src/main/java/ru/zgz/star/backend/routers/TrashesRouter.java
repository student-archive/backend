package ru.zgz.star.backend.routers;

import com.google.gson.Gson;
import ru.zgz.star.backend.daos.TrashDao;
import ru.zgz.star.backend.exceptions.http.MethodNotAllowedException;
import ru.zgz.star.backend.models.Trash;
import spark.Request;
import spark.Response;

/** Router, which handles requests to /trashes. */
public class TrashesRouter {
  /** Base path for all requests, which this router handles. */
  public static final String BASE_URL = "/trashes";

  /**
   * Handles GET requests to /trashes.
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
   * Handles POST requests to /trashes.
   *
   * @param request request object
   * @param response response object
   * @return JSON representation of the created account
   */
  public static String post(Request request, Response response) {
    try {
      response.type("application/json");
      response.status(201);
      TrashDao dao = new TrashDao();
      Trash trash = new Gson().fromJson(request.body(), Trash.class);
      dao.add(trash);
      return new Gson().toJson(trash);
    } catch (Exception e) {
      response.status(500);
      throw e;
    }
  }

  /**
   * Handles PATCH requests to /trashes.
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
   * Handles DELETE requests to /trashes.
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
   * Handles PUT requests to /trashes.
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
