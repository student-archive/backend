package ru.zgz.star.backend.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Set of methods for working with database
 */
public class DbUtil {
  private static Connection connection = null;

  /**
   * Returns or creates connection to database
   * @return connection to database
   */
  public static Connection getConnection() {
    if (connection == null) {
      try {
        String driver = "org.postgresql.Driver";
        String url;
        if (System.getenv("ENV").equals("DEV")) {
          url = System.getenv("TEST_DATABASE_URL");
        } else {
          url = System.getenv("DATABASE_URL");
        }
        String user = System.getenv("DATABASE_USER");
        String password = System.getenv("DATABASE_PASSWORD");
        Class.forName(driver);

        connection = DriverManager.getConnection(url, user, password);
        connection.setAutoCommit(false);
      } catch (ClassNotFoundException | SQLException e) {
        e.printStackTrace();
      }
    }
    return connection;
  }
}
