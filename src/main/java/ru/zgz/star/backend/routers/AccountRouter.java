package ru.zgz.star.backend.routers;

import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import spark.Request;
import spark.Response;

public class AccountRouter {

  public static String BASE_URL = "/account/:id";
  public static Logger logger = LoggerFactory.getLogger(AccountRouter.class);

  public static String getExactAccount(Request request, Response response) {
    response.type("application/json");
//    List<Account> accounts = new QAccount().findList();
//    DAO<Account> dao = new DAO<>(Account.class);
//    String result = dao.findById(request.params("id"));
//    logger.info("Account {} found", result);
//    return result;
    return "";
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
