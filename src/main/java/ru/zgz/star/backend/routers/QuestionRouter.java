package ru.zgz.star.backend.routers;

import com.google.gson.Gson;
import spark.Request;
import spark.Response;

public class QuestionRouter {

  public static String BASE_URL = "/question/:id";

  public static String getExactQuestion(Request request, Response response) {
    response.type("application/json");
    return new Gson().toJson("id:" + request.params(":id"));
  }

  public static String patchExactQuestion(Request request, Response response) {
    response.type("application/json");
    return new Gson().toJson("OK");
  }

  public static String deleteExactQuestion(Request request, Response response) {
    response.type("application/json");
    return new Gson().toJson("OK");
  }
}
