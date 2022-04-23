package ru.zgz.star.backend.routes;

import com.google.gson.Gson;
import spark.Request;
import spark.Response;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class EventsRouter {
  public static String BASE_URL = "/events/:id";

  public static String getExactEvents(Request request, Response response) {
    response.type("application/json");
    return new Gson().toJson("id:" + request.params(":id"));
  }
}
