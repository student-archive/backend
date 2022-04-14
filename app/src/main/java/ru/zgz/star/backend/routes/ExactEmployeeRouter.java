package ru.zgz.star.backend.routes;

import com.google.gson.Gson;
import spark.Request;
import spark.Response;

public class ExactEmployeeRouter {
  public static String BASE_URL = "/Employee/:id";

  public static String getExactEmployee(Request request, Response response) {
    response.type("application/json");
    return new Gson().toJson("id:" + request.params(":id"));
  }

  public static String patchExactEmployee(Request request, Response response) {
    response.type("application/json");
    return new Gson().toJson("OK");
  }

  public static String petExactEmployee(Request request, Response response) {
    response.type("application/json");
    return new Gson().toJson("OK");
  }

  public static String deleteExactEmployee(Request request, Response response) {
    response.type("application/json");
    return new Gson().toJson("OK");
  }
}

