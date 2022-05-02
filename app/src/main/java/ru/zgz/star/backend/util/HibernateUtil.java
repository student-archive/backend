package ru.zgz.star.backend.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.zgz.star.backend.models.Account;

/** Set of utils to work with hibernate */
public class HibernateUtil {
  private static final SessionFactory sessionFactory;

  static {
    try {
      var cfg = new Configuration();
      cfg.setProperty("hibernate.connection.username", System.getenv("DATABASE_USER"));
      cfg.setProperty("hibernate.connection.password", System.getenv("DATABASE_PASSWORD"));
      if (System.getenv("ENV").equals("PROD")) {
        cfg.setProperty("hibernate.connection.url", System.getenv("DATABASE_URL"));
      } else if (System.getenv("ENV").equals("DEV")) {
        cfg.setProperty("hibernate.connection.url", System.getenv("TEST_DATABASE_URL"));
      }

      ClassUtil.findAllClasses("ru.zgz.star.backend.models").forEach(cfg::addAnnotatedClass);

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
