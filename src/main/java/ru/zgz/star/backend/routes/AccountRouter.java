package ru.zgz.star.backend.routes;

import com.google.gson.Gson;
import java.util.UUID;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.zgz.star.backend.daos.AccountDao;
import ru.zgz.star.backend.models.Account;
import ru.zgz.star.backend.responses.DeletedResponse;
import ru.zgz.star.backend.util.ClassUtil;
import spark.Request;
import spark.Response;

public class AccountRouter {

  public static String BASE_URL = "/account/:id";
  public static Logger logger = LoggerFactory.getLogger(AccountRouter.class);

  public static String getExactAccount(Request request, Response response) {
    response.type("application/json");
    AccountDao dao = new AccountDao();
    try {
      if (dao.findById(UUID.fromString(request.params("id")))) {
        Account account = dao.getById(request.params("id"));
        return new Gson().toJson(account);
      } else {
        response.status(404);
        throw new RuntimeException("Account not found");
      }
    } catch (IllegalArgumentException e) {
      response.status(400);
      throw new RuntimeException("Bad request");
    }
  }

  public static String deleteExactAccount(Request request, Response response) {
    response.type("application/json");
    AccountDao dao = new AccountDao();
    try {
      if (dao.findById(UUID.fromString(request.params("id")))) {
        dao.deleteById(UUID.fromString(request.params("id")));
        logger.info("Account {} deleted", request.params("id"));
        return new Gson().toJson(new DeletedResponse(UUID.fromString(request.params("id"))));
      } else {
        response.status(404);
        throw new RuntimeException("Account not found");
      }
    } catch (IllegalArgumentException e) {
      response.status(400);
      throw new RuntimeException("Bad request");
    }
  }

  public static String patchExactAccount(Request request, Response response) {
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
        throw new RuntimeException("Account not found");
      }
    } catch (IllegalArgumentException e) {
      response.status(400);
      throw new RuntimeException("Bad request");
    }
  }

  public static String put(Request request, Response response) {
    response.type("application/json");
    response.status(405);
    throw new RuntimeException("Method not allowed");
  }
}
