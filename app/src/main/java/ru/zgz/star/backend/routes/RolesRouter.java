package ru.zgz.star.backend.routes;

import com.google.gson.Gson;
import spark.Request;
import spark.Response;

public class RolesRouter {
  public static String BASE_URL = "/roles";

  public static String getRoles(Request request, Response response){
    return new Gson().toJson("list of roles");
  }
}
