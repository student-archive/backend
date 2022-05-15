package ru.zgz.star.backend.routers;

import com.google.gson.Gson;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import spark.Request;
import spark.Response;

public class GetSoftwareRouter {

  public static String BASE_URL = "/software";

  public static String getListSoftware(Request request, Response response) {
    response.type("application/json");
    return new Gson().toJson(IntStream.range(1, 6).boxed().collect(Collectors.toList()));
  }
}
