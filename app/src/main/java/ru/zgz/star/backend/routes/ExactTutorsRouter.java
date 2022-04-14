package ru.zgz.star.backend.routes;

import com.google.gson.Gson;
import spark.Request;
import spark.Response;

public class ExactTutorsRouter {
  public static String BASE_URL = "/tutor/:subjectId";

  public static String patchExactTutors(Request request, Response response) {
    response.type("application/json");
    return new Gson().toJson("OK");
}
}
