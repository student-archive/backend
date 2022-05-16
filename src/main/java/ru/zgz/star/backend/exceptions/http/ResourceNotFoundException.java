package ru.zgz.star.backend.exceptions.http;

/** Exception thrown when a resource is not found. */
public class ResourceNotFoundException extends BaseHttpException {
  public ResourceNotFoundException(String message) {
    super(message);
  }
}
