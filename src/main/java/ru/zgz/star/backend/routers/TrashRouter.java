package ru.zgz.star.backend.routers;

import com.google.gson.Gson;
import spark.Request;
import spark.Response;

public class TrashRouter {

  public static String BASE_URL = "/trash/:id";

  public static String getExactDeletedElement(Request request, Response response) {
    response.type("application/json");
    return new Gson().toJson("id:" + request.params(":id"));
  }

  public static String deleteExactDeletedElement(Request request, Response response) {
    response.type("application/json");
    return new Gson().toJson("OK");
  }
}
