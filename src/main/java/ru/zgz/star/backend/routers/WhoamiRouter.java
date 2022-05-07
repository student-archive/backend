package ru.zgz.star.backend.routers;

import com.google.gson.Gson;

public class WhoamiRouter {
  public static final String BASE_URL = "/whoami";

  public static String getWhoami() {
    return new Gson().toJson("username");
  }
}
