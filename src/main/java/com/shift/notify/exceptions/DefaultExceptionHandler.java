package com.shift.notify.exceptions;

public class DefaultExceptionHandler implements Thread.UncaughtExceptionHandler {

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        if (e instanceof NotificationBuilderException) {
            System.out.println(e.getMessage());
            System.exit(0);
        }
    }
}
