package com.shift.notify.notificationsender;

import com.shift.notify.notification.Notification;

public interface NotificationSender {
    void send(Notification notification);

    TypeNotify getType();
}