package ru.zgz.star.backend.routes;

import com.google.gson.Gson;
import java.util.UUID;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.zgz.star.backend.daos.AccountDao;
import ru.zgz.star.backend.models.Account;
import ru.zgz.star.backend.responses.DeletedResponse;
import spark.Request;
import spark.Response;

public class AccountRouter {

  public static String BASE_URL = "/account/:id";
  public static Logger logger = LoggerFactory.getLogger(AccountRouter.class);

  public static String getExactAccount(Request request, Response response) {
    response.type("application/json");
    AccountDao dao = new AccountDao();
    Account account = dao.getById(request.params("id"));
    return new Gson().toJson(account);
  }

  public static String deleteExactAccount(Request request, Response response) {
    response.type("application/json");
    AccountDao dao = new AccountDao();
    dao.deleteById(UUID.fromString(request.params("id")));
    logger.info("Account {} deleted", request.params("id"));
    return new Gson().toJson(new DeletedResponse(UUID.fromString(request.params("id"))));
  }

  public static String patchExactAccount(Request request, Response response) {
    response.type("application/json");
    AccountDao dao = new AccountDao();

    Account account = dao.getById(request.params("id"));

    if (account == null) {
      response.status(404);
      throw new RuntimeException("Account not found");
    }

    Account body = new Gson().fromJson(request.body(), Account.class);

    body.setId(account.getId());

    if (body.getEmail() == null) {
      body.setEmail(account.getEmail());
    }
    if (body.getPasswordHash() == null) {
      body.setPasswordHash(account.getPasswordHash());
    }
    if (body.getLastActiveDate() == null) {
      body.setLastActiveDate(account.getLastActiveDate());
    }

    dao.update(body);
    return new Gson().toJson(body);
  }
}
