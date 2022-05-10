package ru.zgz.star.backend.exceptions.http;

public class MethodNotAllowedException extends RuntimeException {
  public MethodNotAllowedException(String message) {
    super(message);
  }
}
