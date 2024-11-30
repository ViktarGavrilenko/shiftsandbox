package com.shift.notify.exceptions;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DefaultExceptionHandler implements Thread.UncaughtExceptionHandler {

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        if (e instanceof NotificationBuilderException) {
            log.error(e.getMessage());
            System.exit(0);
        } else {
            log.error("Неизвестная ошибка", e);
        }
    }
}
