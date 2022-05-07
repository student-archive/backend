package ru.zgz.star.backend.routers;

import com.google.gson.Gson;

public class UserRouter {
  public static final String BASE_URL = "/user/:id";

  public static String getUser() {
    return new Gson().toJson("user");
  }

  public static String patchUser() {
    return new Gson().toJson("OK");
  }
}
