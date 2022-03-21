package ru.zgz.star.backend;

import static spark.Spark.*;

public class App {

  public static String getGreeting() {
    return "Hello World";
  }
  public static void main(String[] args) {
    get("/hello", (req, res) -> getGreeting());
  }
}
