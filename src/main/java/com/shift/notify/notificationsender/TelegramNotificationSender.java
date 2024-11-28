package com.shift.notify.notificationsender;

import com.shift.notify.notification.Notification;

public class TelegramNotificationSender implements NotificationSender {
    @Override
    public void send(Notification notification) {
        System.out.println(notification.getMessage());
    }

    @Override
    public TypeNotify getType() {
        return TypeNotify.TELEGRAM;
    }
}