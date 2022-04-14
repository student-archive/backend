package ru.zgz.star.backend.routes;

import com.google.gson.Gson;
import spark.Request;
import spark.Response;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PostQuizRouter {

  public static String BASE_URL = "/quiz";

  public static String postQuizzes(Request request, Response response) {
    response.type("application/json");
    return new Gson().toJson("OK");
  }

}
