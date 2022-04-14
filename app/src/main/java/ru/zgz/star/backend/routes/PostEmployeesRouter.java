package ru.zgz.star.backend.routes;

import com.google.gson.Gson;
import spark.Request;
import spark.Response;

public class PostEmployeesRouter {
  public static String BASE_URL = "/employees/:specialtyId";

  public static String postEmployees(Request request, Response response) {
    response.type("application/json");
    return new Gson().toJson("OK");
  }
}
