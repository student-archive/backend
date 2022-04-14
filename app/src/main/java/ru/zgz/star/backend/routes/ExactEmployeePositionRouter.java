package ru.zgz.star.backend.routes;

import com.google.gson.Gson;
import spark.Request;
import spark.Response;

public class ExactEmployeePositionRouter {
  public static String BASE_URL = "/employeePosition/:id";

  public static String getExactEmployeePosition(Request request, Response response) {
    response.type("application/json");
    return new Gson().toJson("id:" + request.params(":id"));
  }

  public static String patchExactEmployeePosition(Request request, Response response) {
    response.type("application/json");
    return new Gson().toJson("OK");
  }

  public static String deleteExactEmployeePosition(Request request, Response response) {
    response.type("application/json");
    return new Gson().toJson("OK");
  }
}
