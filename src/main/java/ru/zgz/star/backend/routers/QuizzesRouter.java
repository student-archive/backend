package ru.zgz.star.backend.routers;

import com.google.gson.Gson;
import ru.zgz.star.backend.daos.AccountDao;
import ru.zgz.star.backend.daos.QuizDao;
import ru.zgz.star.backend.exceptions.http.MethodNotAllowedException;
import ru.zgz.star.backend.models.Account;
import ru.zgz.star.backend.models.Quiz;
import spark.Request;
import spark.Response;

/** Router, which handles requests to /quizzes/:subjectId. */
public class QuizzesRouter {
  /** Base path for all requests, which this router handles. */
  public static final String BASE_URL = "/quizzes/:subjectId";

  /**
   * Handles GET requests to /quizzes/:subjectId.
   *
   * @param request request object
   * @param response response object
   * @return JSON representation of all quizzes
   */
  public static String get(Request request, Response response) {
    response.type("application/json");
    QuizDao dao = new QuizDao();
    return new Gson().toJson(dao.getBySubject(request.params("subjectId")));
  }

  /**
   * Handles POST requests to /quizzes/:subjectId.
   *
   * @param request request object
   * @param response response object
   * @return JSON representation of the created /quizzes/:subjectId
   */
  public static String post(Request request, Response response) {
    response.type("application/json");
    response.status(201);
    QuizDao dao = new QuizDao();
    Quiz quiz = new Gson().fromJson(request.body(), Quiz.class);
    dao.add(quiz);
    return new Gson().toJson(quiz);
  }

  /**
   * Handles PATCH requests to /quizzes/:subjectId.
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
   * Handles DELETE requests to /quizzes/:subjectId.
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
   * Handles PUT requests to /quizzes/:subjectId.
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
