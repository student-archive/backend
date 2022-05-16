package ru.zgz.star.backend.exceptions;

/**
 * Exception, raised when model building failed.
 */
public class ModelBuildException extends RuntimeException {
  public ModelBuildException(String message) {
    super(message);
  }
}
