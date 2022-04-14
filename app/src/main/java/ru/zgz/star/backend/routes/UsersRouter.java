package ru.zgz.star.backend.routes;

import com.google.gson.Gson;

public class UsersRouter {
  public static final String BASE_URL = "/users";

  public static String postUsers() {
    return new Gson().toJson("OK");
  }
}
