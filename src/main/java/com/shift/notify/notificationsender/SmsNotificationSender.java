package com.shift.notify.notificationsender;

import com.shift.notify.notification.SmsNotification;

public class SmsNotificationSender implements NotificationSender<SmsNotification> {
    private static final String MESSAGE = "Отправитель: %s отправил sms сообщение: %s получателю: %s";

    @Override
    public void send(SmsNotification notification) {
        System.out.printf((MESSAGE) + "%n", notification.getSender(),
                notification.getMessage(), notification.getReceiver());
    }

    @Override
    public TypeNotify getType() {
        return TypeNotify.SMS;
    }
}