package ru.zgz.star.backend.routes;

import com.google.gson.Gson;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceException;
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
    try {
      Account entity =
          new Account("test@qwerty.com", "someSuperSecurePassword", Instant.now());
      em.persist(entity);
    } catch (PersistenceException exception) {
      System.err.println(exception.getMessage());
    }
    List<Account> result = em.createQuery("select a from Account a", Account.class).getResultList();
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
