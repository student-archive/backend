package ru.zgz.star.backend.routes;

import com.google.gson.Gson;
import ru.zgz.star.backend.daos.AccountDao;
import ru.zgz.star.backend.models.Account;
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
    response.type("application/json");
    response.status(201);
    AccountDao dao = new AccountDao();
    Account account = new Gson().fromJson(request.body(), Account.class);
    dao.add(account);
    return new Gson().toJson(account);
  }
}
