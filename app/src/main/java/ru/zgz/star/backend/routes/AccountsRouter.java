package ru.zgz.star.backend.routes;

import com.google.gson.Gson;
import ru.zgz.star.backend.models.Account;
import spark.Request;
import spark.Response;

import java.util.List;

public class AccountsRouter {
  public static final String BASE_URL = "/accounts";

  public static String getAccounts(Request request, Response response) {
    response.type("application/json");
    return "";
  }

  public static String postAccounts(Request request, Response response) {
    return new Gson().toJson("OK");
  }
}
