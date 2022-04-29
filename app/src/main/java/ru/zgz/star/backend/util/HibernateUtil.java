package ru.zgz.star.backend.util;

import io.github.cdimascio.dotenv.Dotenv;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.zgz.star.backend.models.Account;

/** Set of utils to work with hibernate */
public class HibernateUtil {
  private static final SessionFactory sessionFactory;

  static {
    try {
      var cfg = new Configuration();
      Dotenv dotenv = Dotenv.load();
      cfg.setProperty("hibernate.connection.url", dotenv.get("DATABASE_URL"));
      cfg.setProperty("hibernate.connection.username", dotenv.get("DATABASE_USER"));
      cfg.setProperty("hibernate.connection.password", dotenv.get("DATABASE_PASSWORD"));
      cfg.addAnnotatedClass(Account.class);

      sessionFactory = cfg.buildSessionFactory();
    } catch (Throwable ex) {
      System.err.println("Initial SessionFactory creation failed." + ex);
      throw new ExceptionInInitializerError(ex);
    }
  }

  /**
   * Gets session factory
   *
   * @return session factory object
   */
  public static SessionFactory getSessionFactory() {
    return sessionFactory;
  }
}
