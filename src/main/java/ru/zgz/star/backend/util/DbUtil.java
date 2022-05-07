package ru.zgz.star.backend.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtil {
  private static Connection connection = null;

  public static Connection getConnection() {
    if (connection == null) {
      try {
        String driver = "org.postgresql.Driver";
        String url = System.getenv("DATABASE_URL");
        String user = System.getenv("DATABASE_USERNAME");
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
