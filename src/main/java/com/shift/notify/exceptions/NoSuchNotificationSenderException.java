package com.shift.notify.exceptions;

public class NoSuchNotificationSenderException extends RuntimeException {
    public NoSuchNotificationSenderException(String message) {
        super(message);
    }
}
