package com.shift.notify.resolver;

import com.shift.notify.LogNotificationSender;
import com.shift.notify.notificationsender.NotificationSender;
import com.shift.notify.notificationsender.TypeNotify;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NotificationResolver {
    private final Map<TypeNotify, NotificationSender> notificationMap;

    public NotificationResolver(List<NotificationSender> notificationSenders) {
        this.notificationMap = new HashMap<>();
        for (NotificationSender notificationSender : notificationSenders) {
            notificationMap.put(notificationSender.getType(), notificationSender);
        }
    }

    public NotificationSender getNotification(TypeNotify typeNotify) {
        return new LogNotificationSender(notificationMap.get(typeNotify));
    }
}