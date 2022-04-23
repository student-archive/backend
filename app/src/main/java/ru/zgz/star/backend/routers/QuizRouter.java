package ru.zgz.star.backend.routers;

import com.google.gson.Gson;
import spark.Request;
import spark.Response;

public class QuizRouter {

  public static String BASE_URL = "/quiz/:id";

  public static String getExactQuiz(Request request, Response response) {
    response.type("application/json");
    return new Gson().toJson("id:" + request.params(":id"));
  }

  public static String patchExactQuiz(Request request, Response response) {
    response.type("application/json");
    return new Gson().toJson("OK");
  }

  public static String deleteExactQuiz(Request request, Response response) {
    response.type("application/json");
    return new Gson().toJson("OK");
  }
}
