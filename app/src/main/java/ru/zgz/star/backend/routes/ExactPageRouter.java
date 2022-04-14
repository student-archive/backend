package ru.zgz.star.backend.routes;

import com.google.gson.Gson;
import spark.Request;
import spark.Response;

public class ExactPageRouter {
  public static String BASE_URL = "/Page/:id";

  public static String getExactPage(Request request, Response response) {
    response.type("application/json");
    return new Gson().toJson("id:" + request.params(":id"));
  }

  public static String patchExactPage(Request request, Response response) {
    response.type("application/json");
    return new Gson().toJson("OK");
  }

  public static String deleteExactPage(Request request, Response response) {
    response.type("application/json");
    return new Gson().toJson("OK");
  }
}
