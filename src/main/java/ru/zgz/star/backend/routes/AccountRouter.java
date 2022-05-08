package ru.zgz.star.backend.routes;

import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.zgz.star.backend.daos.AccountDao;
import ru.zgz.star.backend.models.Account;
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
    logger.info("Account {} deleted", request.params("id"));
    return new Gson().toJson("OK");
  }

  public static String patchExactAccount(Request request, Response response) {
    response.type("application/json");
    return new Gson().toJson("OK");
  }
}
