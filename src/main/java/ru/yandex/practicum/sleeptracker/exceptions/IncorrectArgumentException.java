package ru.yandex.practicum.sleeptracker.exceptions;

public class IncorrectArgumentException extends RuntimeException {
    public IncorrectArgumentException(String message) {
        super(message);
    }
}
