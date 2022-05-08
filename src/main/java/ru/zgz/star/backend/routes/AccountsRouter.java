package ru.zgz.star.backend.routes;

import com.google.gson.Gson;
import ru.zgz.star.backend.daos.AccountDao;
import spark.Request;
import spark.Response;

public class AccountsRouter {
  public static final String BASE_URL = "/accounts";

  public static String getAccounts(Request request, Response response) {
    response.type("application/json");
    AccountDao dao = new AccountDao();
    return new Gson().toJson(dao.getAll());
  }

  public static String postAccounts(Request request, Response response) {
    return new Gson().toJson("OK");
  }
}
