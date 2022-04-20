package ru.zgz.star.backend.routes;

import com.google.gson.Gson;
import jakarta.persistence.EntityManager;
import ru.zgz.star.backend.models.Account;
import ru.zgz.star.backend.util.HibernateUtil;
import spark.Request;
import spark.Response;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

public class AccountRouter {

  public static String BASE_URL = "/account/:id";

  public static String getExactAccount(Request request, Response response) {
    response.type("application/json");
    var sessionFactory = HibernateUtil.getSessionFactory();
    EntityManager em = sessionFactory.createEntityManager();
    em.getTransaction().begin();
    Account entity = new Account(UUID.randomUUID(), "test", "someSuperSecurePassword",
      Instant.now());
    em.persist(entity);  // FIXME: detached entity passed to persist
    List<Account> result =
        em.createQuery("select a from Account a where id=:id", Account.class)
            .setParameter("id", UUID.fromString(request.params("id")))
            .getResultList();
    em.getTransaction().commit();
    em.close();
    return new Gson().toJson(result);
  }

  public static String deleteExactAccount(Request request, Response response) {
    response.type("application/json");
    return new Gson().toJson("OK");
  }

  public static String patchExactAccount(Request request, Response response) {
    response.type("application/json");
    return new Gson().toJson("OK");
  }
}
