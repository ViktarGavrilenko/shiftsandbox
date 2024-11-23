package com.shift.notify.notification;

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
            return new TelegramNotification(this);
        }
    }
}
