package ru.zgz.star.backend.routers;

import com.google.gson.Gson;
import java.util.List;
import java.util.UUID;
import ru.zgz.star.backend.daos.SoftwareDao;
import ru.zgz.star.backend.daos.SubjectDao;
import ru.zgz.star.backend.exceptions.http.BadRequestException;
import ru.zgz.star.backend.exceptions.http.MethodNotAllowedException;
import ru.zgz.star.backend.exceptions.http.ResourceNotFoundException;
import ru.zgz.star.backend.models.Software;
import spark.Request;
import spark.Response;

/** Router, which handles requests to /software/:subjectId. */
public class SoftwareRouter {
  /** Base path for all requests, which this router handles. */
  public static final String BASE_URL = "/software/:subjectId";

  /**
   * Handles GET requests to /software/:subjectId.
   *
   * @param request request object
   * @param response response object
   * @return JSON representation of all software by subject
   */
  public static String get(Request request, Response response) {
    response.type("application/json");
    SoftwareDao softwareDao = new SoftwareDao();
    SubjectDao subjectDao = new SubjectDao();
    try {
      if (subjectDao.findById(UUID.fromString(request.params("subjectId")))) {
        List<Software> software = softwareDao.getBySubject(request.params("subjectId"));
        return new Gson().toJson(software);
      } else {
        response.status(404);
        throw new ResourceNotFoundException(
            String.format("Subject id=%s not found", request.params("subjectId")));
      }
    } catch (IllegalArgumentException e) {
      response.status(400);
      throw new BadRequestException(
          String.format("Given UUID (%s) is not valid", request.params("subjectId")));
    } catch (Exception e) {
      e.printStackTrace();
      response.status(500);
      throw e;
    }
  }

  /**
   * Handles POST requests to /software/:subjectId.
   *
   * @param request request object
   * @param response response object
   * @return JSON representation of the created account
   */
  public static String post(Request request, Response response) {
    try {
      response.type("application/json");
      response.status(201);
      SoftwareDao dao = new SoftwareDao();
      Software software = new Gson().fromJson(request.body(), Software.class);
      dao.add(software);
      return new Gson().toJson(software);
    } catch (Exception e) {
      response.status(500);
      throw e;
    }
  }

  /**
   * Handles PATCH requests to /software/:subjectId.
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
   * Handles DELETE requests to /software/:subjectId.
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
   * Handles PUT requests to /software/:subjectId.
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
