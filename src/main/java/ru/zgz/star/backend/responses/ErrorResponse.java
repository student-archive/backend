package ru.zgz.star.backend.responses;

/**
 * Model, representing response which returned, when happened some shit on server.
 */
public class ErrorResponse {
  public Integer code;
  public String message;

  public String exception = null;

  public ErrorResponse(Integer code, String message) {
    this.code = code;
    this.message = message;
  }

  public ErrorResponse(Integer code, String message, String exception) {
    this.code = code;
    this.message = message;
    this.exception = exception;
  }
}
