package com.shift.notify.notification;

import com.shift.notify.exceptions.InvalidEmailException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailNotification implements Notification {
    private String message;
    private String sender;
    private String receiver;
    private String emailReceiver;

    public EmailNotification(Builder builder) {
        this.message = builder.message;
        this.sender = builder.sender;
        this.receiver = builder.receiver;
        this.emailReceiver = builder.emailReceiver;
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
        private String emailReceiver;

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

        public Builder emailReceiver(String emailReceiver) {
            Pattern pattern = Pattern.compile("^[A-Za-z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Za-z]{2,6}$");
            Matcher matcher = pattern.matcher(emailReceiver);
            if (matcher.matches()) {
                this.emailReceiver = emailReceiver;
            } else {
                throw new InvalidEmailException("Невалидный емайл");
            }
            return this;
        }

        public EmailNotification build() {
            //Валидация
            return new EmailNotification(this);
        }
    }
}
