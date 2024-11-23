package com.shift.notify;

import com.shift.notify.notification.Notification;
import com.shift.notify.notificationsender.NotificationSender;
import com.shift.notify.notificationsender.TypeNotify;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LogNotificationSender implements NotificationSender {
    private final NotificationSender notificationSender;
    private static final String PATTERN_TIME = "yyyy-MM-dd HH:mm:ss";
    private static final String LOG_SEND = "Сообщение типа: '%s' отправлено. Время %s";
    private static final String LOG_GET = "Сообщение типа: '%s' получено. Время %s";

    public LogNotificationSender(NotificationSender notificationSender) {
        this.notificationSender = notificationSender;
    }

    @Override
    public void send(Notification notification) {
        System.out.printf((LOG_SEND) + "%n", notificationSender.getType(),
                LocalDateTime.now().format(DateTimeFormatter.ofPattern(PATTERN_TIME)));
        notificationSender.send(notification);
        System.out.printf((LOG_GET) + "%n", notificationSender.getType(),
                LocalDateTime.now().format(DateTimeFormatter.ofPattern(PATTERN_TIME)));
    }

    @Override
    public TypeNotify getType() {
        return notificationSender.getType();
    }
}