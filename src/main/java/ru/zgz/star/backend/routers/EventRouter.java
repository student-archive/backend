package ru.zgz.star.backend.routers;

import com.google.gson.Gson;
import spark.Request;
import spark.Response;

public class EventRouter {

  public static String BASE_URL = "/event/:groupId";

  public static String getExactEvent(Request request, Response response) {
    response.type("application/json");
    return new Gson().toJson("id:" + request.params(":id"));
  }

  public static String patchExactEvent(Request request, Response response) {
    response.type("application/json");
    return new Gson().toJson("OK");
  }

  public static String deleteExactEvent(Request request, Response response) {
    response.type("application/json");
    return new Gson().toJson("OK");
  }
}
