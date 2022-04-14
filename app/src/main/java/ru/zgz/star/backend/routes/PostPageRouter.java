package ru.zgz.star.backend.routes;

import com.google.gson.Gson;
import spark.Request;
import spark.Response;

public class PostPageRouter {
  public static String BASE_URL = "/page/:subjectID";

  public static String postPage(Request request, Response response) {
    response.type("application/json");
    return new Gson().toJson("OK");
  }
}
