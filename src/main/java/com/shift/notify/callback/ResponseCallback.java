package com.shift.notify.callback;

import com.shift.notify.notification.Notification;
import com.shift.notify.notificationsender.NotificationResponse;

public interface ResponseCallback<V extends Notification> {
    void onResponse(NotificationResponse notificationResponse, V notification);
}