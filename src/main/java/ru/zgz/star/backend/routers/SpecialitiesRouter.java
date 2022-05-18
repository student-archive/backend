package ru.zgz.star.backend.routers;

import com.google.gson.Gson;
import ru.zgz.star.backend.daos.SpecialityDao;
import ru.zgz.star.backend.exceptions.http.MethodNotAllowedException;
import ru.zgz.star.backend.models.Speciality;
import spark.Request;
import spark.Response;

/** Router, which handles requests to /specialities. */
public class SpecialitiesRouter {
  /** Base path for all requests, which this router handles. */
  public static final String BASE_URL = "/specialities";

  /**
   * Handles GET requests to /specialities.
   *
   * @param request request object
   * @param response response object
   * @return JSON representation of all specialities
   */
  public static String get(Request request, Response response) {
    response.type("application/json");
    SpecialityDao dao = new SpecialityDao();
    return new Gson().toJson(dao.getAll());
  }

  /**
   * Handles POST requests to /specialities.
   *
   * @param request request object
   * @param response response object
   * @return JSON representation of the created specialities
   */
  public static String post(Request request, Response response) {
    try {
      response.type("application/json");
      response.status(201);
      SpecialityDao dao = new SpecialityDao();
      Speciality speciality = new Gson().fromJson(request.body(), Speciality.class);
      dao.add(speciality);
      return new Gson().toJson(speciality);
    } catch (Exception e) {
      response.status(500);
      throw e;
    }
  }

  /**
   * Handles PATCH requests to /specialities.
   *
   * @param request request object
   * @param response response object
   * @return JSON representation of the 405 error
   */
  public static String patch(Request request, Response response) {
    response.type("application/json");
    response.status(405);
    throw new MethodNotAllowedException("Method PATCH is not allowed for this resource");
  }

  /**
   * Handles DELETE requests to /specialities.
   *
   * @param request request object
   * @param response response object
   * @return JSON representation of the 405 error
   */
  public static String delete(Request request, Response response) {
    response.type("application/json");
    response.status(405);
    throw new MethodNotAllowedException("Method DELETE is not allowed for this resource");
  }

  /**
   * Handles PUT requests to /specialities.
   *
   * @param request request object
   * @param response response object
   * @return JSON representation of the 405 error
   */
  public static String put(Request request, Response response) {
    response.type("application/json");
    response.status(405);
    throw new MethodNotAllowedException("Method PUT is not allowed for this resource");
  }
}
