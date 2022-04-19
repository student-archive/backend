package ru.zgz.star.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/** Entry point of the application */
@SpringBootApplication
public class App {
  /**
   * Executable method with definition of endpoints and connecting to database
   *
   * @param args Command-line arguments
   */
  public static void main(String[] args) {
    SpringApplication.run(App.class, args);
  }
}
