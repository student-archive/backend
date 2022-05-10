package ru.zgz.star.backend.exceptions.http;

/** Exception for bad request. */
public class BadRequestException extends RuntimeException {
  public BadRequestException(String message) {
    super(message);
  }
}
