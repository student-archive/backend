package ru.zgz.star.backend.exceptions.http;

public class BadRequestException extends RuntimeException{
    public BadRequestException(String message) {
        super(message);
    }
}
