package ru.zgz.star.backend.responses;

/** Model, representing response which returned when happened some shit on server. */
public class ErrorResponse {
  /** HTTP status code. */
  public Integer code;
  /** Error message. */
  public String message;

  /** Class name of exception. */
  public String exception = null;

  /** Instantiates a new empty Error response. */
  public ErrorResponse() {
    this.code = null;
    this.message = null;
    this.exception = null;
  }

  /**
   * Instantiates a new Error response.
   *
   * @param code http status code
   * @param message error message
   */
  public ErrorResponse(Integer code, String message) {
    this.code = code;
    this.message = message;
  }

  /**
   * Constructor for error response.
   *
   * @param code http status code
   * @param message error message
   * @param exception exception, which happened
   */
  public ErrorResponse(Integer code, String message, String exception) {
    this.code = code;
    this.message = message;
    this.exception = exception;
  }

  /**
   * Gets the code.
   *
   * @return http status code
   */
  public Integer getCode() {
    return code;
  }

  /**
   * Sets the code.
   *
   * @param code http status code
   */
  public void setCode(Integer code) {
    this.code = code;
  }

  /**
   * Gets the message.
   *
   * @return error message
   */
  public String getMessage() {
    return message;
  }

  /**
   * Sets the message.
   *
   * @param message error message
   */
  public void setMessage(String message) {
    this.message = message;
  }

  /**
   * Gets the exception.
   *
   * @return exception, which happened
   */
  public String getException() {
    return exception;
  }

  /**
   * Sets the exception.
   *
   * @param exception exception, which happened
   */
  public void setException(String exception) {
    this.exception = exception;
  }
}
