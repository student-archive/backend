package ru.zgz.star.backend.routes;

import com.google.gson.Gson;
import spark.Request;
import spark.Response;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SpecialitiesRouter {
  public static String BASE_URL = "/specialities/:groupId";

  public static String getSpecialities(Request request, Response response) {
    response.type("application/json");
    return new Gson().toJson(IntStream.range(1, 6).boxed().collect(Collectors.toList()));
  }
}
