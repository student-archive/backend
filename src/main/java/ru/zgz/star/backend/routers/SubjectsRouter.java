package ru.zgz.star.backend.routers;

import com.google.gson.Gson;
import ru.zgz.star.backend.daos.AccountDao;
import ru.zgz.star.backend.daos.SubjectDao;
import ru.zgz.star.backend.exceptions.http.MethodNotAllowedException;
import ru.zgz.star.backend.models.Account;
import ru.zgz.star.backend.models.Subject;
import spark.Request;
import spark.Response;

/** Router, which handles requests to /subjects. */
public class SubjectsRouter {
  /** Base path for all requests, which this router handles. */
  public static final String BASE_URL = "/subjects";

  /**
   * Handles GET requests to /subjects.
   *
   * @param request request object
   * @param response response object
   * @return JSON representation of all subjects
   */
  public static String get(Request request, Response response) {
    response.type("application/json");
    SubjectDao dao = new SubjectDao();
    return new Gson().toJson(dao.getAll());
  }

  /**
   * Handles POST requests to /subjects.
   *
   * @param request request object
   * @param response response object
   * @return JSON representation of the created subject
   */
  public static String post(Request request, Response response) {
    try {
      response.type("application/json");
      response.status(201);
      SubjectDao dao = new SubjectDao();
      Subject subject = new Gson().fromJson(request.body(), Subject.class);
      dao.add(subject);
      return new Gson().toJson(subject);
    } catch (Exception e) {
      response.status(500);
      throw e;
    }
  }

  /**
   * Handles PATCH requests to /subjects.
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
   * Handles DELETE requests to /subjects.
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
   * Handles PUT requests to /subjects.
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
