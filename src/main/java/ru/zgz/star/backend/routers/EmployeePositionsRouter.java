package ru.zgz.star.backend.routers;

import com.google.gson.Gson;
import ru.zgz.star.backend.daos.AccountDao;
import ru.zgz.star.backend.daos.EmployeePositionDao;
import ru.zgz.star.backend.exceptions.http.MethodNotAllowedException;
import ru.zgz.star.backend.models.Account;
import ru.zgz.star.backend.models.EmployeePosition;
import spark.Request;
import spark.Response;

/** Router, which handles requests to /employeePositions. */
public class EmployeePositionsRouter {
  /** Base path for all requests, which this router handles. */
  public static final String BASE_URL = "/employeePositions";

  /**
   * Handles GET requests to /employeePositions.
   *
   * @param request request object
   * @param response response object
   * @return JSON representation of all employeePositions
   */
  public static String get(Request request, Response response) {
    response.type("application/json");
    EmployeePositionDao dao = new EmployeePositionDao();
    return new Gson().toJson(dao.getAll());
  }

  /**
   * Handles POST requests to /accounts.
   *
   * @param request request object
   * @param response response object
   * @return JSON representation of the created employeePositions
   */
  public static String post(Request request, Response response) {
    try {
      response.type("application/json");
      response.status(201);
      EmployeePositionDao dao = new EmployeePositionDao();
      EmployeePosition employeePosition = new Gson().fromJson(request.body(), EmployeePosition.class);
      dao.add(employeePosition);
      return new Gson().toJson(employeePosition);
    } catch (Exception e) {
      response.status(500);
      throw e;
    }
  }

  /**
   * Handles PATCH requests to /accounts.
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
   * Handles DELETE requests to /accounts.
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
   * Handles PUT requests to /accounts.
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
