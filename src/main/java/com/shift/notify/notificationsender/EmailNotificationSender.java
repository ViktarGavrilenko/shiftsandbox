package com.shift.notify.notificationsender;

import com.shift.notify.callback.ResponseCallback;
import com.shift.notify.notification.EmailNotification;

public class EmailNotificationSender implements NotificationSender<EmailNotification> {
    private static final String MESSAGE = "Отправитель: %s отправил email сообщение: %s с адреса: %s получателю: %s";

    @Override
    public NotificationResponse send(EmailNotification notification) {
        return new NotificationResponse
                .Builder()
                .status(NotificationResult.OK)
                .body(String.format(MESSAGE, notification.getSender(), notification.getMessage(),
                        notification.getEmailReceiver(), notification.getReceiver()))
                .build();
    }

    @Override
    public TypeNotify getType() {
        return TypeNotify.EMAIL;
    }

    @Override
    public void sendAsync(EmailNotification emailNotification, ResponseCallback<EmailNotification> callback) {
        new Thread(() -> callback
                .onResponse(send(emailNotification), emailNotification))
                .start();
    }
}