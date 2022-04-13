package ru.zgz.star.backend.routes;

import com.google.gson.Gson;
import ru.zgz.star.backend.models.Account;
import spark.Request;
import spark.Response;

import java.util.UUID;

public class GetAccountRouter {

  public static String BASE_URL = "/account";

  public static String getExactAccount(Request request, Response response) {
    response.type("application/json");
    return new Gson()
        .toJson(new Account().setId(UUID.randomUUID()).setUsername("" + request.params(":id")));
  }
}
