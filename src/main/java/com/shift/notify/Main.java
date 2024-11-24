package com.shift.notify;

import com.shift.notify.exceptions.DefaultExceptionHandler;
import com.shift.notify.notification.EmailNotification;
import com.shift.notify.notificationsender.EmailNotificationSender;
import com.shift.notify.notificationsender.NotificationSender;
import com.shift.notify.notificationsender.SmsNotificationSender;
import com.shift.notify.notificationsender.TelegramNotificationSender;
import com.shift.notify.notificationsender.TypeNotify;
import com.shift.notify.resolver.NotificationResolver;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Thread.currentThread().setUncaughtExceptionHandler(new DefaultExceptionHandler());

        List<NotificationSender> notificationSenders = new ArrayList<>();
        notificationSenders.add(new EmailNotificationSender());
        notificationSenders.add(new SmsNotificationSender());
        notificationSenders.add(new TelegramNotificationSender());
        NotificationResolver resolver = new NotificationResolver(notificationSenders);

        FacadeRootSender facadeRootSender = new FacadeRootSender();
        EmailNotification emailNotification = new EmailNotification
                .Builder().message("Текст сообщения электронной почты").emailReceiver("mail@mail.by").build();
        facadeRootSender.send(resolver.getNotification(TypeNotify.EMAIL), emailNotification);
    }
}