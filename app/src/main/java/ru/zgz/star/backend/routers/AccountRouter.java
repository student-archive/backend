package ru.zgz.star.backend.routers;

//public class AccountRouter {
//
//  public static String BASE_URL = "/account/:id";
//  public static Logger logger =
//      LoggerFactory.getLogger(AccountRouter.class); // Создание объекта логгера
//
//  public static String getExactAccount(Request request, Response response) {
//    response.type("application/json");
//    List<Account> result = new ArrayList<>();
//    try (SessionFactory sf =
//        HibernateUtil
//            .getSessionFactory()) { // Создание фабрики сессий. Она автоматически закроется после
//                                    // завершения блока try
//      EntityManager em = sf.createEntityManager(); // Создание менеждера сущностей
//      em.getTransaction().begin(); // Открытие транзакций
//      Account entity =
//          new Account(
//              "test@qwerty.com",
//              "someSuperSecurePassword",
//              Instant.now()); // Создание нового объекта класса Account
//      em.persist(entity); // Сохранение записи созданной выше в БД
//      result =
//          em.createQuery("select a from Account a", Account.class)
//              .getResultList(); // Селект всех аккаунтов в список моделей Account
//      em.getTransaction().commit(); // Применение изменений (должно быть даже после селектов)
//      em.close(); // Закрытие менеджера сущностей
//    } catch (Exception err) {
//      logger.error(err.getMessage());
//    }
//    return new Gson().toJson(result);
//  }
//
//  public static String deleteExactAccount(Request request, Response response) {
//    response.type("application/json");
//    return new Gson().toJson("OK");
//  }
//
//  public static String patchExactAccount(Request request, Response response) {
//    response.type("application/json");
//    return new Gson().toJson("OK");
//  }
//}