package com.shift.notify.notificationsender;

import com.shift.notify.notification.TelegramNotification;

public class TelegramNotificationSender implements NotificationSender<TelegramNotification> {
    private static final String MESSAGE = "Отправитель: %s отправил sms сообщение: %s получателю: %s";

    @Override
    public void send(TelegramNotification notification) {
        System.out.printf((MESSAGE) + "%n", notification.getSender(),
                notification.getMessage(), notification.getReceiver());
    }

    @Override
    public TypeNotify getType() {
        return TypeNotify.TELEGRAM;
    }
}