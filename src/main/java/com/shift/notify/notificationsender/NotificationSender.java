package com.shift.notify.notificationsender;

import com.shift.notify.notification.Notification;

public interface NotificationSender<V extends Notification> {
    void send(V notification);

    TypeNotify getType();
}