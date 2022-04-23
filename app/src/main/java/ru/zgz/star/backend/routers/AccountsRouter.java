package ru.zgz.star.backend.routers;

import com.google.gson.Gson;

public class AccountsRouter {
  public static final String BASE_URL = "/accounts";

  public static String postAccounts() {
    return new Gson().toJson("OK");
  }
}
