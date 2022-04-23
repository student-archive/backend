package ru.zgz.star.backend.routers;

import com.google.gson.Gson;
import spark.Request;
import spark.Response;

public abstract class BaseRouter {
  public static String BASE_URL = "";

  public static String get(Request request, Response response) {
    response.status(405);
    return new Gson().toJson(new Error("Method not allowed"));
  }

  public static String post(Request request, Response response) {
    response.status(405);
    return new Gson().toJson(new Error("Method not allowed"));
  }

  public static String put(Request request, Response response) {
    response.status(405);
    return new Gson().toJson(new Error("Method not allowed"));
  }

  public static String delete(Request request, Response response) {
    response.status(405);
    return new Gson().toJson(new Error("Method not allowed"));
  }
}
