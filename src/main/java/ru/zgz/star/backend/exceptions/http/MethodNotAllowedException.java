package ru.zgz.star.backend.exceptions.http;

/** Exception thrown when the HTTP method is not allowed. */
public class MethodNotAllowedException extends RuntimeException {
  public MethodNotAllowedException(String message) {
    super(message);
  }
}
