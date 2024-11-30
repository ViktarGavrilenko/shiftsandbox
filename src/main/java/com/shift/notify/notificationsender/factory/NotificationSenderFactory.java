package com.shift.notify.notificationsender.factory;

import com.shift.notify.notification.Notification;
import com.shift.notify.notificationsender.NotificationSender;

import java.util.List;

public interface NotificationSenderFactory {
    List<NotificationSender<? extends Notification>> getNotificationSenders();
}
