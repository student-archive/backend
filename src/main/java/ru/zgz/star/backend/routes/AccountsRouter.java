package ru.zgz.star.backend.routes;

import com.google.gson.Gson;
import ru.zgz.star.backend.daos.AccountDao;
import ru.zgz.star.backend.exceptions.http.MethodNotAllowedException;
import ru.zgz.star.backend.models.Account;
import spark.Request;
import spark.Response;

/** Router, which handles requests to /accounts. */
public class AccountsRouter {
  /** Base path for all requests, which this router handles. */
  public static final String BASE_URL = "/accounts";

  /**
   * Handles GET requests to /accounts.
   *
   * @param request request object
   * @param response response object
   * @return JSON representation of all accounts
   */
  public static String get(Request request, Response response) {
    response.type("application/json");
    AccountDao dao = new AccountDao();
    return new Gson().toJson(dao.getAll());
  }

  /**
   * Handles POST requests to /accounts.
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
