package com.shift.notify;

import com.shift.notify.exceptions.DefaultExceptionHandler;
import com.shift.notify.notification.EmailNotification;
import com.shift.notify.notification.SmsNotification;
import com.shift.notify.notification.TelegramNotification;
import com.shift.notify.notificationsender.factory.NotificationSenderFactory;
import com.shift.notify.notificationsender.factory.NotificationSendersAllFactory;
import com.shift.notify.resolver.NotificationResolver;


public class Main {
    public static void main(String[] args) {
        Thread.currentThread().setUncaughtExceptionHandler(new DefaultExceptionHandler());

        NotificationSenderFactory sendersAllFactory = new NotificationSendersAllFactory();
        NotificationResolver resolver = new NotificationResolver(sendersAllFactory.getNotificationSenders());

        FacadeRootSender facadeRootSender = new FacadeRootSender();
        EmailNotification emailNotification = new EmailNotification
                .Builder().message("email message")
                .emailReceiver("mail@mail.by")
                .receiver("email receiver")
                .sender("email sender").build();
        TelegramNotification telegramNotification = new TelegramNotification.Builder()
                .message("telegram message").receiver("telegram receiver").sender("telegram sender")
                .build();
        facadeRootSender.send(resolver.getNotificationSender(emailNotification), emailNotification);

        facadeRootSender.send(resolver.getNotificationSender(telegramNotification), telegramNotification);

        facadeRootSender.sendAsync(resolver.getNotificationSender(telegramNotification), telegramNotification);

        SmsNotification smsNotification = new SmsNotification.Builder()
                .message("sms message")
                .receiver("sms receiver")
                .sender("sms sender")
                .build();
        facadeRootSender.send(resolver.getNotificationSender(smsNotification), smsNotification);
    }
}