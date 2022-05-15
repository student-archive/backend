package ru.zgz.star.backend.exceptions.http;

public class BaseHttpException extends RuntimeException{

  public BaseHttpException(String message){
    super(message);
  }

}
