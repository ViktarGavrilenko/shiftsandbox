package com.shift.notify.notification;

import com.shift.notify.notificationsender.TypeNotify;

public interface Notification {
    String getMessage();
    String getSender();
    String getReceiver();
    TypeNotify getType();
}