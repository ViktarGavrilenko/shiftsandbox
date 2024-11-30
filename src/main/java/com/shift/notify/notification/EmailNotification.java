package com.shift.notify.notification;

import com.shift.notify.exceptions.NotificationBuilderException;
import com.shift.notify.notificationsender.TypeNotify;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.shift.notify.utils.NotificationExceptionConstants.NOT_VALID_EMAIL;
import static com.shift.notify.utils.NotificationExceptionConstants.NOT_VALID_RECEIVER;
import static com.shift.notify.utils.NotificationExceptionConstants.NOT_VALID_SENDER;

public class EmailNotification implements Notification {
    private final String message;
    private final String sender;
    private final String receiver;
    private final String emailReceiver;


    private EmailNotification(Builder builder) {
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

    @Override
    public TypeNotify getType() {
        return TypeNotify.EMAIL;
    }

    public String getEmailReceiver() {
        return emailReceiver;
    }

    public static class Builder {
        private String message;
        private String sender;
        private String receiver;
        private String emailReceiver;
        private static final String REGEX_EMAIL = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";

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
            this.emailReceiver = emailReceiver;
            return this;
        }

        public EmailNotification build() {
            buildValidate();
            return new EmailNotification(this);
        }

        private void buildValidate() {
            Pattern pattern = Pattern.compile(REGEX_EMAIL);
            Matcher matcher = pattern.matcher(emailReceiver);
            if (!matcher.matches()) {
                throw new NotificationBuilderException(NOT_VALID_EMAIL);
            }
            if (receiver == null || receiver.isEmpty()) {
                throw new NotificationBuilderException(NOT_VALID_RECEIVER);
            }
            if (sender == null || sender.isEmpty()) {
                throw new NotificationBuilderException(NOT_VALID_SENDER);
            }
        }
    }
}
