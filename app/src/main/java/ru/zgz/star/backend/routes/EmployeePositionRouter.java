package ru.zgz.star.backend.routes;

import com.google.gson.Gson;
import spark.Request;
import spark.Response;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class EmployeePositionRouter {
  public static String BASE_URL = "/employeePosition/:id";

  public static String getemployeePosition(Request request, Response response) {
    response.type("application/json");
    return new Gson().toJson(IntStream.range(1, 6).boxed().collect(Collectors.toList()));
  }
}
