package ru.zgz.star.backend.routes;

import com.google.gson.Gson;
import spark.Request;
import spark.Response;

public class PostTutorsRouter {
  public static String BASE_URL = "/tutor";

  public static String postTutor(Request request, Response response) {
    response.type("application/json");
    return new Gson().toJson("OK");
  }
}
