package ru.zgz.star.backend.exceptions.http;

/** Exception for bad request. */
public class BadRequestException extends BaseHttpException {
  /**
   * Instantiates a new Bad request exception.
   *
   * @param message error message
   */
  public BadRequestException(String message) {
    super(message);
  }
}
