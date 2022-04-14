package ru.zgz.star.backend.routes;

import com.google.gson.Gson;
import spark.Request;
import spark.Response;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class QuestionsRouter {

  public static String BASE_URL = "/quiz/:id/questions";

  public static String getQuestions(Request request, Response response) {
    response.type("application/json");
    return new Gson().toJson(IntStream.range(1, 6).boxed().collect(Collectors.toList()));
  }
  public static String postQuestions(Request request, Response response) {
    response.type("application/json");
    return new Gson().toJson("OK");
  }

}
