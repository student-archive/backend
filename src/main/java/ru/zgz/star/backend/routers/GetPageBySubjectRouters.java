package ru.zgz.star.backend.routers;

import com.google.gson.Gson;
import java.util.List;
import java.util.UUID;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.zgz.star.backend.daos.AccountDao;
import ru.zgz.star.backend.daos.PageDao;
import ru.zgz.star.backend.daos.SubjectDao;
import ru.zgz.star.backend.exceptions.http.BadRequestException;
import ru.zgz.star.backend.exceptions.http.MethodNotAllowedException;
import ru.zgz.star.backend.exceptions.http.ResourceNotFoundException;
import ru.zgz.star.backend.models.Account;
import ru.zgz.star.backend.models.Page;
import ru.zgz.star.backend.responses.DeletedResponse;
import ru.zgz.star.backend.util.ClassUtil;
import spark.Request;
import spark.Response;

/** Router, which handles requests to /pages/:subject. */
public class GetPageBySubjectRouters {

  /** Base path for all requests, which this router handles. */
  public static String BASE_URL = "/pages/:subject";
  /** Logger for this class. */
  public static Logger logger = LoggerFactory.getLogger(GetPageBySubjectRouters.class);

  /**
   * Handles GET request to  /pages/:subject.
   *
   * @param request request object
   * @param response request object
   * @return JSON representation of all subject
   */
  public static String get(Request request, Response response) {
    response.type("application/json");
    PageDao dao = new PageDao();
    SubjectDao subjectDao = new SubjectDao();
    try {
      if (subjectDao.findById(UUID.fromString(request.params("subject")))) {
        List<Page> page = dao.getBySubjectId(request.params("id"));
        return new Gson().toJson(page);
      } else {
        response.status(404);
        throw new ResourceNotFoundException(
            String.format("Page id=%s not found", request.params("id")));
      }
    } catch (IllegalArgumentException e) {
      response.status(400);
      throw new BadRequestException(
          String.format("Given UUID (%s) is not valid", request.params("id")));
    }
  }

  /**
   * Handles DELETE requests to /pages/:subject.
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
   * Handles PATCH requests to /pages/:subject..
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
   * Handles PUT requests to /pages/:subject..
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

  /**
   * Handles POST requests to/pages/:subject.
   *
   * @param request request object
   * @param response response object
   * @return JSON representation of the created subject
   */
  public static String post(Request request, Response response) {
    response.type("application/json");
    response.status(201);
    PageDao dao = new PageDao();
    Page page = new Gson().fromJson(request.body(), Page.class);
    dao.add(page);
    return new Gson().toJson(page);
  }
}