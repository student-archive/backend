package ru.zgz.star.backend.exceptions.http;

/** Exception thrown when the HTTP method is not allowed. */
public class MethodNotAllowedException extends BaseHttpException {
  /**
   * Instantiates a new method not allowed exception.
   *
   * @param message message of the exception
   */
  public MethodNotAllowedException(String message) {
    super(message);
  }
}
