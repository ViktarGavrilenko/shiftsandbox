package com.shift.notify.notificationsender;

import com.shift.notify.notification.EmailNotification;

public class EmailNotificationSender implements NotificationSender<EmailNotification> {
    private static final String MESSAGE = "Отправитель: %s отправил email сообщение: %s с адреса: %s получателю: %s";

    @Override
    public void send(EmailNotification emailNotification) {
        System.out.printf((MESSAGE) + "%n", emailNotification.getSender(), emailNotification.getMessage(),
                emailNotification.getEmailReceiver(), emailNotification.getReceiver());

    }

    @Override
    public TypeNotify getType() {
        return TypeNotify.EMAIL;
    }
}