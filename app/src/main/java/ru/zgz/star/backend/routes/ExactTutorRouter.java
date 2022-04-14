package ru.zgz.star.backend.routes;

import com.google.gson.Gson;
import spark.Request;
import spark.Response;

public class ExactTutorRouter {
  public static String BASE_URL = "/tutor/:id";

  public static String getExactTutor(Request request, Response response) {
    response.type("application/json");
    return new Gson().toJson("id:" + request.params(":id"));
  }

  public static String patchExactTutor(Request request, Response response) {
    response.type("application/json");
    return new Gson().toJson("OK");
  }

  public static String deleteExactTutor(Request request, Response response) {
    response.type("application/json");
    return new Gson().toJson("OK");
  }
}
