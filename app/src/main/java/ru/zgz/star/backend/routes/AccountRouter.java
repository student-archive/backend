package ru.zgz.star.backend.routes;

import com.google.gson.Gson;
import jakarta.persistence.EntityManager;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.zgz.star.backend.models.Account;
import ru.zgz.star.backend.util.HibernateUtil;
import spark.Request;
import spark.Response;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class AccountRouter {

  public static String BASE_URL = "/account/:id";
  public static Logger logger =
      LoggerFactory.getLogger(AccountRouter.class); // Создание объекта логгера

  public static String getExactAccount(Request request, Response response) {
    response.type("application/json");
    List<Account> result = new ArrayList<>();
    try (SessionFactory sf =
        HibernateUtil
            .getSessionFactory()) { // Создание фабрики сессий. Она автоматически закроется после
                                    // завершения блока try
      EntityManager em = sf.createEntityManager(); // Создание менеждера сущностей
      em.getTransaction().begin(); // Открытие транзакций
      result =
          em.createQuery("select a from Account a", Account.class)
              .getResultList(); // Селект всех аккаунтов в список моделей Account
      em.getTransaction().commit(); // Применение изменений (должно быть даже после селектов)
      em.close(); // Закрытие менеджера сущностей
    } catch (Exception err) {
      logger.error(err.getMessage());
    }
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
