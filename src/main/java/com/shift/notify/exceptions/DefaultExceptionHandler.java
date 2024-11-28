package com.shift.notify.exceptions;

import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;

public class DefaultExceptionHandler implements Thread.UncaughtExceptionHandler {

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        if (e instanceof NotificationBuilderException) {
            System.out.println(e.getMessage());
            System.exit(0);
        } else {
            System.out.println(Arrays.stream(e.getStackTrace()).map(Objects::toString)
                    .collect(Collectors.joining("\n")));
            System.out.println(e.getMessage());
            System.out.println(e.getClass());
        }
    }
}
