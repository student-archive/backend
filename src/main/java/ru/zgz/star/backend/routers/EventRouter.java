package ru.zgz.star.backend.routers;

import com.google.gson.Gson;
import spark.Request;
import spark.Response;

/**
 * Router, which handles requests to /event/:groupId.
 */
public class EventRouter {

  /**
   * Base path for all requests, which this router handles
   */
  public static String BASE_URL = "/event/:groupId";

  /**
   * Handles GET request to /event/:groupId
   * @param request request object
   * @param response response object
   * @return JSON representation of exact event
   */
  public static String getExactEvent(Request request, Response response) {
    response.type("application/json");
    return new Gson().toJson("id:" + request.params(":id"));
  }

  /**
   * Handles PATCH request to /event/:groupId
   * @param request request object
   * @param response response object
   * @return JSON representation of updated event
   */
  public static String patchExactEvent(Request request, Response response) {
    response.type("application/json");
    return new Gson().toJson("OK");
  }

  /**
   * Handles DELETE request to /event/:groupId
   * @param request request object
   * @param response response object
   * @return JSON representation of deleted event
   */
  public static String deleteExactEvent(Request request, Response response) {
    response.type("application/json");
    return new Gson().toJson("OK");
  }
}
