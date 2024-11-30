package com.shift.notify.notificationsender;

import lombok.Getter;

@Getter
public class NotificationResponse {
    private NotificationResult status;
    private String body;

    public NotificationResponse(Builder builder) {
        this.status = builder.status;
        this.body = builder.body;
    }

    public static class Builder {
        private NotificationResult status;
        private String body;

        public NotificationResponse.Builder status(NotificationResult status) {
            this.status = status;
            return this;
        }

        public NotificationResponse.Builder body(String body) {
            this.body = body;
            return this;
        }

        public NotificationResponse build() {
            return new NotificationResponse(this);
        }
    }
}