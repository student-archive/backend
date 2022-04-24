package ru.zgz.star.backend.routes;

import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.zgz.star.backend.models.Account;
import ru.zgz.star.backend.repository.DAO;
import spark.Request;
import spark.Response;

public class AccountRouter {

  public static String BASE_URL = "/account/:id";
  public static Logger logger =
      LoggerFactory.getLogger(AccountRouter.class); // Создание объекта логгера

  public static String getExactAccount(Request request, Response response) {
    response.type("application/json");
    DAO<Account> dao = new DAO<>(Account.class);
    Account result = dao.findById(request.params("id"));
    return new Gson().toJson(result);
  }

  public static String deleteExactAccount(Request request, Response response) {
    response.type("application/json");
    DAO<Account> dao = new DAO<>(Account.class);
    dao.delete(request.params("id"));
    return new Gson().toJson("OK");
  }

  public static String patchExactAccount(Request request, Response response) {
    response.type("application/json");
    return new Gson().toJson("OK");
  }
}
