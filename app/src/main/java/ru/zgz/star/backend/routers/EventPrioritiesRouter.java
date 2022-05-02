package ru.zgz.star.backend.routers;

import com.google.gson.Gson;
import ru.zgz.star.backend.models.EventPriority;
import ru.zgz.star.backend.repository.DAO;
import spark.Request;
import spark.Response;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class EventPrioritiesRouter {
  public static String BASE_URL = "/eventPriorities";

  public static String getPriorities(Request request, Response response) {
    response.type("application/json");
    DAO<EventPriority> dao = new DAO<>(EventPriority.class);
    return new Gson().toJson(dao.findAll());
  }
}
