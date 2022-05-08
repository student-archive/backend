package ru.zgz.star.backend.routers;

import com.google.gson.Gson;

public class GroupRouter {
  public static final String BASE_URL = "/group/:id";

  public static String getGroups() {
    return new Gson().toJson("group");
  }

  public static String patchGroup() {
    return new Gson().toJson("OK");
  }

  public static String deleteGroup() {
    return new Gson().toJson("OK");
  }
}
