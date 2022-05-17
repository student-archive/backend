package ru.zgz.star.backend.routers;

import com.google.gson.Gson;
import ru.zgz.star.backend.daos.AccountDao;
import ru.zgz.star.backend.daos.PageDao;
import ru.zgz.star.backend.exceptions.http.MethodNotAllowedException;
import ru.zgz.star.backend.models.Account;
import ru.zgz.star.backend.models.Page;
import spark.Request;
import spark.Response;

/** Router, which handles requests to /pages. */
public class PagesRouter {
  /** Base path for all requests, which this router handles. */
  public static final String BASE_URL = "/pages";

  /**
   * Handles GET requests to /pages.
   *
   * @param request request object
   * @param response response object
   * @return JSON representation of all pages
   */
  public static String get(Request request, Response response) {
    response.type("application/json");
    PageDao dao = new PageDao();
    return new Gson().toJson(dao.getAll());
  }

  /**
   * Handles POST requests to /pages.
   *
   * @param request request object
   * @param response response object
   * @return JSON representation of the created page
   */
  public static String post(Request request, Response response) {
    try {
      response.type("application/json");
      response.status(201);
      PageDao dao = new PageDao();
      Page page = new Gson().fromJson(request.body(), Page.class);
      dao.add(page);
      return new Gson().toJson(page);
    } catch (Exception e) {
      response.status(500);
      throw e;
    }
  }

  /**
   * Handles PATCH requests to /pages.
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
   * Handles DELETE requests to /pages.
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
   * Handles PUT requests to /pages.
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
