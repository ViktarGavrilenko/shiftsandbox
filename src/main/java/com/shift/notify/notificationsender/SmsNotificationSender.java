package com.shift.notify.notificationsender;

import com.shift.notify.notification.SmsNotification;

public class SmsNotificationSender implements NotificationSender<SmsNotification> {
    private static final String MESSAGE = "Отправитель: %s отправил sms сообщение: %s получателю: %s";

    @Override
    public NotificationResponse send(SmsNotification notification) {
        return new NotificationResponse
                .Builder()
                .status(NotificationResult.OK)
                .body(String.format(MESSAGE, notification.getSender(), notification.getMessage(), notification.getReceiver()))
                .build();
    }

    @Override
    public TypeNotify getType() {
        return TypeNotify.SMS;
    }

    @Override
    public void sendAsync(SmsNotification smsNotification) {
        new Thread(() -> send(smsNotification)).start();
    }
}