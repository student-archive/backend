package ru.zgz.star.backend.routes;

import com.google.gson.Gson;
import spark.Request;
import spark.Response;

public class PostAttachmentRouter {public static String BASE_URL = "/attachment/:subjectId";

  public static String postAttachment(Request request, Response response) {
    response.type("application/json");
    return new Gson().toJson("OK");
  }
}
