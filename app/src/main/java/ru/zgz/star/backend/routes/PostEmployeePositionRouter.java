package ru.zgz.star.backend.routes;

import com.google.gson.Gson;
import spark.Request;
import spark.Response;

public class PostEmployeePositionRouter {
  public static String BASE_URL = "/EmployeePosition";

  public static String postEmployeePosition(Request request, Response response) {
    response.type("application/json");
    return new Gson().toJson("OK");
  }
}
