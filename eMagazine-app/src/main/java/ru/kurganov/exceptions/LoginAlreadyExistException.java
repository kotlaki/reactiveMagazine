package ru.kurganov.exceptions;

public class LoginAlreadyExistException extends RuntimeException {

    private static final String LOGIN_ALREADY_EXIST = "Пользователь с логином %s уже уществует!";

    public LoginAlreadyExistException(String message) {
        super(message);
    }

    public static LoginAlreadyExistException byUserName(String userName) {
        return new LoginAlreadyExistException(String.format(LOGIN_ALREADY_EXIST, userName));
    }
}
