package ru.zgz.star.backend.exceptions.http;

/**
 * Base HTTP exception for all HTTP exceptions.
 */
public class BaseHttpException extends RuntimeException {

  public BaseHttpException(String message) {
    super(message);
  }
}
