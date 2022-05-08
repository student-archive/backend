package ru.zgz.star.backend.routers;

import com.google.gson.Gson;
import spark.Request;
import spark.Response;

public class PostTrashRouter {

  public static String BASE_URL = "/trash";

  public static String postElementToTrash(Request request, Response response) {
    response.type("application/json");
    return new Gson().toJson("OK");
  }
}
