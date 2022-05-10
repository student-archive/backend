package ru.zgz.star.backend.routers;

import spark.Request;
import spark.Response;

/**
 * Router, which handles requests to the /eventPriorities.
 */
public class EventPrioritiesRouter {
  /**
   * Base URL of this router.
   */
  public static String BASE_URL = "/eventPriorities";

  /**
   * Handles GET requests to the /eventPriorities.
   * @param request request object
   * @param response response object
   * @return JSON representation of available event priorities
   */
  public static String getPriorities(Request request, Response response) {
    response.type("application/json");
    return "";
  }
}
