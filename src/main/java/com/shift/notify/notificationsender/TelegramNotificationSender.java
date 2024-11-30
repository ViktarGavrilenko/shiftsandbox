package com.shift.notify.notificationsender;

import com.shift.notify.notification.TelegramNotification;

public class TelegramNotificationSender implements NotificationSender<TelegramNotification> {
    private static final String MESSAGE = "Отправитель: %s отправил sms сообщение: %s получателю: %s";

    @Override
    public NotificationResponse send(TelegramNotification notification) {
        return new NotificationResponse
                .Builder()
                .status(NotificationResult.OK)
                .body(String.format(MESSAGE, notification.getSender(), notification.getMessage(), notification.getReceiver()))
                .build();
    }

    @Override
    public TypeNotify getType() {
        return TypeNotify.TELEGRAM;
    }

    @Override
    public void sendAsync(TelegramNotification telegramNotification) {
        new Thread(() -> send(telegramNotification)).start();
    }
}