package com.shift.notify.resolver;

import com.shift.notify.LogNotificationSender;
import com.shift.notify.exceptions.NoSuchNotificationSenderException;
import com.shift.notify.notification.Notification;
import com.shift.notify.notificationsender.NotificationSender;
import com.shift.notify.notificationsender.TypeNotify;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NotificationResolver {
    private final Map<TypeNotify, NotificationSender<? extends Notification>> notificationMap;

    public NotificationResolver(List<NotificationSender<? extends Notification>> notificationSenders) {
        this.notificationMap = new HashMap<>();
        for (NotificationSender<? extends Notification> notificationSender : notificationSenders) {
            notificationMap.put(notificationSender.getType(), notificationSender);
        }
    }

    public NotificationSender<Notification> getNotificationSender(Notification notification) {
        if (notificationMap.get(notification.getType()) == null) {
            throw new NoSuchNotificationSenderException("Нет такого типа sender: " + notification.getType());
        }
        return new LogNotificationSender(notificationMap.get(notification.getType()));
    }
}