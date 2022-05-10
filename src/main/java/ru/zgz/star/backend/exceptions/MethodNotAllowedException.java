package ru.zgz.star.backend.exceptions;

public class MethodNotAllowedException extends RuntimeException {
  public MethodNotAllowedException(String message) {
    super(message);
  }
}
