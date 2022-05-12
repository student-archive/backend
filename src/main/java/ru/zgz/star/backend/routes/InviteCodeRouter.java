package ru.zgz.star.backend.routes;

import com.google.gson.Gson;
import ru.zgz.star.backend.daos.InviteCodeDao;
import ru.zgz.star.backend.models.InviteCode;
import spark.Request;
import spark.Response;

/** Router, which handles requests to /inviteCodes. */
public class InviteCodeRouter {

  /** Base path for all requests, which this router handles. */
  public static final String BASE_URL = "/inviteCodes";

  /**
   * Handles POST requests to /inviteCodes.
   *
   * @param request request object
   * @param response response object
   * @return JSON representation of the created invite code
   */
  public static String post(Request request, Response response) {
    response.type("application/json");
    response.status(201);
    InviteCodeDao inviteCodeDao = new InviteCodeDao();
    InviteCode inviteCode = new Gson().fromJson(request.body(), InviteCode.class);
    inviteCodeDao.add(inviteCode);
    return new Gson().toJson(inviteCode);
  }
}
