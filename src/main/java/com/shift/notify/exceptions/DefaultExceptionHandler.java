package com.shift.notify.exceptions;

public class DefaultExceptionHandler implements Thread.UncaughtExceptionHandler {

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        if (e instanceof InvalidEmailException) {
            System.out.println("Невалидный емайл");
            System.exit(0);
        }
    }
}
