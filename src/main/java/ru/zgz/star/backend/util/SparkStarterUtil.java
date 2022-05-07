package ru.zgz.star.backend.util;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.zgz.star.backend.App;
import spark.Spark;



/** Utility class to start a spark server in a test environment. */
public class SparkStarterUtil {

  public static Logger logger = LoggerFactory.getLogger(SparkStarterUtil.class);

  /** The Spark port. */
  protected Integer sparkPort = 4567;

  /**
   * Checks if Spark server is running.
   *
   * @return running status
   */
  public boolean isRunning() {
    try {
      HttpURLConnection con =
          (HttpURLConnection) new URL("http", "localhost", sparkPort, "/ping").openConnection();
      return con.getResponseCode() == 200;
    } catch (Exception e) {
      return false;
    }
  }

  /**
   * Start server.
   *
   * @throws IOException the io exception
   * @throws NoSuchFieldException the no such field exception
   * @throws IllegalAccessException the illegal access exception
   */
  public void startServer() throws IOException, NoSuchFieldException, IllegalAccessException {
    App.main(null);
  }

  /**
   * Start spark app if not running.
   *
   * @param expectedPort the expected port
   */
  public void startSparkAppIfNotRunning(Integer expectedPort) {
    sparkPort = expectedPort;

    try {
      logger.info("Checking if running for integration tests");
      if (!isRunning()) {
        logger.info("Not running - starting");
        startServer();
        logger.info("Running spark to start");
      }
    } catch (IllegalStateException
        | IOException
        | NoSuchFieldException
        | IllegalAccessException e) {
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

  /** Kill server. */
  public void killServer() {

    Spark.stop();
    Spark.awaitStop();

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

  /**
   * Gets port.
   *
   * @return the port
   */
  public Integer getPort() {
    return sparkPort;
  }
}
