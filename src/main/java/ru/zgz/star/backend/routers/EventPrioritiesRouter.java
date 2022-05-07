package ru.zgz.star.backend.routers;

import spark.Request;
import spark.Response;

public class EventPrioritiesRouter {
  public static String BASE_URL = "/eventPriorities";

  public static String getPriorities(Request request, Response response) {
    response.type("application/json");
    return "";
  }
}
