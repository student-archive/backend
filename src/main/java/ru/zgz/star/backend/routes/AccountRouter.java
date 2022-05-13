package ru.zgz.star.backend.routes;

import com.google.gson.Gson;
import java.util.UUID;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.zgz.star.backend.daos.AccountDao;
import ru.zgz.star.backend.exceptions.http.BadRequestException;
import ru.zgz.star.backend.exceptions.http.MethodNotAllowedException;
import ru.zgz.star.backend.exceptions.http.ResourceNotFoundException;
import ru.zgz.star.backend.models.Account;
import ru.zgz.star.backend.responses.DeletedResponse;
import ru.zgz.star.backend.util.ClassUtil;
import spark.Request;
import spark.Response;

/** Router, which handles requests to /account/:id. */
public class AccountRouter {

  /** Base path for all requests, which this router handles. */
  public static String BASE_URL = "/account/:id";
  /** Logger for this class. */
  public static Logger logger = LoggerFactory.getLogger(AccountRouter.class);

  /**
   * Handles GET request to /account/:id.
   *
   * @param request request object
   * @param response response object
   * @return JSON representation of exact account
   */
  public static String get(Request request, Response response) {
    response.type("application/json");
    AccountDao dao = new AccountDao();
    try {
      if (dao.findById(UUID.fromString(request.params("id")))) {
        Account account = dao.getById(request.params("id"));
        return new Gson().toJson(account);
      } else {
        response.status(404);
        throw new ResourceNotFoundException(
            String.format("Account id=%s not found", request.params("id")));
      }
    } catch (IllegalArgumentException e) {
      response.status(400);
      throw new BadRequestException(
          String.format("Given UUID (%s) is not valid", request.params("id")));
    }
  }

  /**
   * Handles DELETE request to /account/:id.
   *
   * @param request request object
   * @param response response object
   * @return JSON representation of id of deleted account
   */
  public static String delete(Request request, Response response) {
    response.type("application/json");
    AccountDao dao = new AccountDao();
    try {
      if (dao.findById(UUID.fromString(request.params("id")))) {
        dao.deleteById(UUID.fromString(request.params("id")));
        logger.info("Account {} deleted", request.params("id"));
        return new Gson().toJson(new DeletedResponse(UUID.fromString(request.params("id"))));
      } else {
        response.status(404);
        throw new ResourceNotFoundException(
            String.format("Account id=%s not found", request.params("id")));
      }
    } catch (IllegalArgumentException e) {
      response.status(400);
      throw new BadRequestException("Passed UUID is not valid");
    }
  }

  /**
   * Handles PATCH request to /account/:id.
   *
   * @param request request object
   * @param response response object
   * @return JSON representation of updated account
   */
  public static String patch(Request request, Response response) {
    response.type("application/json");
    AccountDao dao = new AccountDao();

    try {
      if (dao.findById(UUID.fromString(request.params("id")))) {
        logger.info("Account {} found", request.params("id"));
        Account account = dao.getById(request.params("id"));
        Account body = new Gson().fromJson(request.body(), Account.class);
        body.setId(account.getId());
        Account updated = (Account) ClassUtil.mergeObjects(body, account);
        dao.update(updated);
        return new Gson().toJson(updated);
      } else {
        response.status(404);
        throw new ResourceNotFoundException(
            String.format("Account id=%s not found", request.params("id")));
      }
    } catch (IllegalArgumentException e) {
      response.status(400);
      throw new BadRequestException("Passed UUID is not valid");
    }
  }

  /**
   * Handles PUT request to /account/:id.
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
   * Handles POST request to /account/:id.
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
}
