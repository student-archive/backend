package ru.zgz.star.backend.routes;

import com.google.gson.Gson;
import spark.Request;
import spark.Response;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TrashRouter {

  public static String BASE_URL = "/trash/:id";

  public static String getExactDeletedElement(Request request, Response response) {
    response.type("application/json");
    return new Gson().toJson("id:" + request.params(":id"));
  }

  public static String deleteExactDeletedElement(Request request, Response response) {
    response.type("application/json");
    return new Gson().toJson("OK");
  }
}
