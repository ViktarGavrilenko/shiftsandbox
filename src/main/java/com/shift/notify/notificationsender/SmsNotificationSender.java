package com.shift.notify.notificationsender;

import com.shift.notify.notification.Notification;

public class SmsNotificationSender implements NotificationSender {
    @Override
    public void send(Notification notification) {
        System.out.println("sms notification");
    }

    @Override
    public TypeNotify getType() {
        return TypeNotify.SMS;
    }
}