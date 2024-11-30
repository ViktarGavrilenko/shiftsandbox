package com.shift.notify.callback;

import com.shift.notify.notification.EmailNotification;
import com.shift.notify.notificationsender.NotificationResponse;
import com.shift.notify.notificationsender.NotificationResult;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class EmailResponseCallback implements ResponseCallback<EmailNotification> {
    @Override
    public void onResponse(NotificationResponse notificationResponse, EmailNotification notification) {
        if (notificationResponse.getStatus().equals(NotificationResult.OK)) {
            log.info(notificationResponse.getBody());
        } else {
            log.info("Ошибка во время выполнения");
        }
    }
}