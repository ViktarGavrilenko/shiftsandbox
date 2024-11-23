package com.shift.notify;

import com.shift.notify.notification.Notification;
import com.shift.notify.notificationsender.NotificationSender;

public class FacadeRootSender {
    public void send(NotificationSender notificationSender, Notification notification) {
        notificationSender.send(notification);
    }
}