package ru.zgz.star.backend.routes;

import com.google.gson.Gson;
import spark.Request;
import spark.Response;

public class PostEventsRouter {
  public static String BASE_URL = "/events";

  public static String postEvents(Request request, Response response) {
    response.type("application/json");
    return new Gson().toJson("OK" );
  }
}
