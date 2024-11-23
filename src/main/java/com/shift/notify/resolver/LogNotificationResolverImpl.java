/*
package com.shift.notify.resolver;

import com.shift.notify.LogNotificationSender;
import com.shift.notify.notification.NotificationSender;
import com.shift.notify.notification.TypeNotify;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LogNotificationResolverImpl implements NotificationResolver {
    private final Map<TypeNotify, NotificationSender> notificationMap;

    public LogNotificationResolverImpl(List<NotificationSender> notificationSenders) {
        this.notificationMap = new HashMap<>();
        for (NotificationSender notificationSender : notificationSenders) {
            notificationMap.put(notificationSender.getType(), notificationSender);
        }
    }

    @Override
    public NotificationSender getNotification(TypeNotify typeNotify) {
        return new LogNotificationSender(notificationMap.get(typeNotify));
    }
}
*/
