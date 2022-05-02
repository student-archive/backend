package ru.zgz.star.backend.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.zgz.star.backend.App;
import spark.Spark;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class SparkStarterUtil {

  public static Logger logger = LoggerFactory.getLogger(SparkStarterUtil.class);
  protected int sparkPort = 4567;

  public boolean isRunning() {
    try {
      HttpURLConnection con =
          (HttpURLConnection) new URL("http", "localhost", sparkPort, "/ping").openConnection();
      return con.getResponseCode() == 200;
    } catch (Exception e) {
      return false;
    }
  }

  public void startServer() throws IOException, NoSuchFieldException, IllegalAccessException {
    App.main(null);
  }

  public void startSparkAppIfNotRunning(int expectedPort) {
    sparkPort = expectedPort;

    try {
      logger.info("Checking if running for integration tests");
      if (!isRunning()) {
        logger.info("Not running - starting");
        startServer();
        logger.info("Running spark to start");
      }
    } catch (IllegalStateException | IOException | NoSuchFieldException | IllegalAccessException e) {
      e.printStackTrace();
      logger.error("TODO: Investigate - " + e.getMessage());
    }

    try {
      sparkPort = Spark.port();
    } catch (Exception e) {
      logger.warn("Could not get actual Spark port");
    }

    waitForServerToRun();
  }

  private void waitForServerToRun() {
    int tries = 10;
    while (tries > 0) {
      if (!isRunning()) {
        try {
          Thread.sleep(1000);
        } catch (InterruptedException e1) {
          e1.printStackTrace();
        }
      } else {
        return;
      }
      tries--;
    }

    logger.warn("Server might not have started");
  }

  public void killServer() {

    Spark.stop();
    Spark.awaitStop();

    // TODO: trust the awaitStop

    // wait until server has stopped
    int tries = 10;
    while (tries > 0) {

      logger.info("Checking if server has stopped");

      if (isRunning()) {
        try {
          logger.info("Spark threads " + Spark.activeThreadCount());
          Thread.sleep(1000);
        } catch (InterruptedException e1) {
          e1.printStackTrace();
        }
      } else {
        logger.info("Server has stopped");
        return;
      }
      tries--;
    }

    logger.info("Server might not have stopped");
  }

  public int getPort() {
    return sparkPort;
  }
}
