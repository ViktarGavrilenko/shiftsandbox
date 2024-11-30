package com.shift.notify.notificationsender;

import com.shift.notify.callback.ResponseCallback;
import com.shift.notify.notification.Notification;

public interface NotificationSender<V extends Notification> {
    NotificationResponse send(V notification);

    TypeNotify getType();

    void sendAsync(V notification, ResponseCallback<V> callback);
}