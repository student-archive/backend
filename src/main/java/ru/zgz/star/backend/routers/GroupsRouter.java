package ru.zgz.star.backend.routers;

import com.google.gson.Gson;

public class GroupsRouter {
  public static final String BASE_URL = "/groups";

  public static String getGroups() {
    return new Gson().toJson("groups");
  }

  public static String postGroup() {
    return new Gson().toJson("OK");
  }
}
