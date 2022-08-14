package ru.kurganov.exceptions;

public class EmagazineException extends RuntimeException {

    public EmagazineException(String message) {
        super(message);
    }

    public EmagazineException(String message, Throwable cause) {
        super(message, cause);
    }

}
