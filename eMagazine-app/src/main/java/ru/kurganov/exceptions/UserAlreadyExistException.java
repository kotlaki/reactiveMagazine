package ru.kurganov.exceptions;

public class UserAlreadyExistException extends EmagazineException {

    private static final String USER_ALREADY = "Пользователь с именем %s уже зарегестрирован!";

    public UserAlreadyExistException(String message) {
        super(message);
    }

    public UserAlreadyExistException(String message, Throwable cause) {
        super(message, cause);
    }

    public static UserAlreadyExistException userAlreadyExistByName (String userName) {
        return new UserAlreadyExistException(String.format(USER_ALREADY, userName));
    }
}
