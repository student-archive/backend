package ru.zgz.star.backend.routers;

import com.google.gson.Gson;
import spark.Request;
import spark.Response;

public class PostQuizRouter {

  public static String BASE_URL = "/quiz";

  public static String postQuizzes(Request request, Response response) {
    response.type("application/json");
    return new Gson().toJson("OK");
  }
}
