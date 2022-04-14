package ru.zgz.star.backend.routes;

import com.google.gson.Gson;
import spark.Request;
import spark.Response;

public class ExactSpecialityRouter {
  public static String BASE_URL = "/Speciality/:id";

  public static String getExactSpeciality(Request request, Response response) {
    response.type("application/json");
    return new Gson().toJson("id:" + request.params(":id"));
  }

  public static String patchExactSpeciality(Request request, Response response) {
    response.type("application/json");
    return new Gson().toJson("OK");
  }

  public static String deleteExactSpeciality(Request request, Response response) {
    response.type("application/json");
    return new Gson().toJson("OK");
  }
}
