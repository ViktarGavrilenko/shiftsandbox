package com.shift.notify.notification;

public class SmsNotification implements Notification {
    private final String message;
    private final String sender;
    private final String receiver;

    public SmsNotification(String message, String sender, String receiver) {
        this.message = message;
        this.sender = sender;
        this.receiver = receiver;
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

}
