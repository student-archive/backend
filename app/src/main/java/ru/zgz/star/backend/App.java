package ru.zgz.star.backend;

import static spark.Spark.*;

/**
 * Entry point of the application
 */
public class App {

  /**
   * Some test method to show how Spark works
   * @return hello world string
   */
  public static String getGreeting() {
    return "Hello World";
  }

  /**
   * Executable method with definition of endpoints
   * @param args Command-line arguments
   */
  public static void main(String[] args) {
    get("/hello", (req, res) -> getGreeting());
  }
}
