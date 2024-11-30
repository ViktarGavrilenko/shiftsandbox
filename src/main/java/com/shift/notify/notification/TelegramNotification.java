package com.shift.notify.notification;

import com.shift.notify.exceptions.NotificationBuilderException;
import com.shift.notify.notificationsender.TypeNotify;

import static com.shift.notify.utils.NotificationExceptionConstants.NOT_VALID_RECEIVER;
import static com.shift.notify.utils.NotificationExceptionConstants.NOT_VALID_SENDER;

public class TelegramNotification implements Notification {
    private String message;
    private String sender;
    private String receiver;


    public TelegramNotification(Builder builder) {
        this.message = builder.message;
        this.sender = builder.sender;
        this.receiver = builder.receiver;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public String getSender() {
        return sender;
    }

    @Override
    public String getReceiver() {
        return receiver;
    }

    @Override
    public TypeNotify getType() {
        return TypeNotify.TELEGRAM;
    }

    public static class Builder {
        private String message;
        private String sender;
        private String receiver;

        public Builder message(String message) {
            this.message = message;
            return this;
        }

        public Builder sender(String sender) {
            this.sender = sender;
            return this;
        }

        public Builder receiver(String receiver) {
            this.receiver = receiver;
            return this;
        }

        public TelegramNotification build() {
            buildValidate();
            return new TelegramNotification(this);
        }

        private void buildValidate() {
            if (receiver == null || receiver.isEmpty()) {
                throw new NotificationBuilderException(NOT_VALID_RECEIVER);
            }
            if (sender == null || sender.isEmpty()) {
                throw new NotificationBuilderException(NOT_VALID_SENDER);
            }
        }
    }
}