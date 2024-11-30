package com.shift.notify;

import com.shift.notify.notification.Notification;
import com.shift.notify.notificationsender.NotificationResponse;
import com.shift.notify.notificationsender.NotificationSender;
import com.shift.notify.notificationsender.TypeNotify;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LogNotificationSender implements NotificationSender<Notification> {
    private final NotificationSender notificationSender;
    private static final String PATTERN_TIME = "yyyy-MM-dd HH:mm:ss";
    private static final String LOG_SEND = "Сообщение типа: '%s' отправлено. Время %s";
    private static final String LOG_GET = "Сообщение типа: '%s' получено. Время %s";

    public LogNotificationSender(NotificationSender notificationSender) {
        this.notificationSender = notificationSender;
    }

    @Override
    public NotificationResponse send(Notification notification) {

        System.out.printf((LOG_SEND) + "%n", notificationSender.getType(),
                LocalDateTime.now().format(DateTimeFormatter.ofPattern(PATTERN_TIME)));
        NotificationResponse response = notificationSender.send(notification);
        System.out.println("Статус: " + response.getStatus() + ", тело: " + response.getBody());
        System.out.printf((LOG_GET) + "%n", notificationSender.getType(),
                LocalDateTime.now().format(DateTimeFormatter.ofPattern(PATTERN_TIME)));
        return response;
    }

    @Override
    public TypeNotify getType() {
        return notificationSender.getType();
    }

    @Override
    public void sendAsync(Notification notification) {
        new Thread(() -> send(notification)).start();
    }
}