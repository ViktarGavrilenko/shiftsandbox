package com.shift.notify;

import com.shift.notify.exceptions.DefaultExceptionHandler;
import com.shift.notify.notification.EmailNotification;
import com.shift.notify.notification.SmsNotification;
import com.shift.notify.notification.TelegramNotification;
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
                .Builder().message("email message")
                .emailReceiver("mail@mail.by")
                .receiver("email receiver")
                .sender("email sender").build();
        facadeRootSender.send(resolver.getNotification(TypeNotify.EMAIL), emailNotification);

        TelegramNotification telegramNotification = new TelegramNotification.Builder()
                .message("telegram message").receiver("telegram receiver").sender("telegram sender")
                .build();
        facadeRootSender.send(resolver.getNotification(TypeNotify.TELEGRAM), telegramNotification);

        SmsNotification smsNotification = new SmsNotification.Builder()
                .message("sms message")
                .receiver("sms receiver")
                .sender("sms sender")
                .build();
        facadeRootSender.send(resolver.getNotification(TypeNotify.SMS), smsNotification);
    }
}