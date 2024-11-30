package com.shift.notify.notificationsender.factory;

import com.shift.notify.notification.Notification;
import com.shift.notify.notificationsender.EmailNotificationSender;
import com.shift.notify.notificationsender.NotificationSender;
import com.shift.notify.notificationsender.SmsNotificationSender;

import java.util.ArrayList;
import java.util.List;

public class NotificationSenderSmsEmailFactory implements NotificationSenderFactory {
    @Override
    public List<NotificationSender<? extends Notification>> getNotificationSenders() {
        List<NotificationSender<? extends Notification>> notificationSenders = new ArrayList<>();
        notificationSenders.add(new EmailNotificationSender());
        notificationSenders.add(new SmsNotificationSender());
        return notificationSenders;
    }
}