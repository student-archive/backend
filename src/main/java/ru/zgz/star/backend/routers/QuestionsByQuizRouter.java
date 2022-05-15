package ru.zgz.star.backend.routers;

import com.google.gson.Gson;
import ru.zgz.star.backend.daos.AccountDao;
import ru.zgz.star.backend.daos.QuestionDao;
import ru.zgz.star.backend.exceptions.http.MethodNotAllowedException;
import ru.zgz.star.backend.models.Account;
import spark.Request;
import spark.Response;

/** Router, which handles requests to /quiz/:id/questions. */
public class QuestionsByQuizRouter {
  /** Base path for all requests, which this router handles. */
  public static final String BASE_URL = "/quiz/:id/questions";

  /**
   * Handles GET requests to /quiz/:id/questions.
   *
   * @param request request object
   * @param response response object
   * @return JSON representation of all questions of exact quiz
   */
  public static String get(Request request, Response response) {
    response.type("application/json");
    QuestionDao dao = new QuestionDao();
    return new Gson().toJson(dao.getByQuizId(request.params("id")));
  }

  /**
   * Handles POST requests to /quiz/:id/questions.
   *
   * @param request request object
   * @param response response object
   * @return JSON representation of the created account
   */
  public static String post(Request request, Response response) {
    response.type("application/json");
    response.status(201);
    AccountDao dao = new AccountDao();
    Account account = new Gson().fromJson(request.body(), Account.class);
    dao.add(account);
    return new Gson().toJson(account);
  }

  /**
   * Handles PATCH requests to /quiz/:id/questions.
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
   * Handles DELETE requests to /quiz/:id/questions.
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
   * Handles PUT requests to /quiz/:id/questions.
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
