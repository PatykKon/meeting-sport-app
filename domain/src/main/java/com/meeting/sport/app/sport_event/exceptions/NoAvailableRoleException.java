package com.meeting.sport.app.sport_event.exceptions;

public class NoAvailableRoleException extends RuntimeException {
    public NoAvailableRoleException(String message) {
        super(message);
    }

    public NoAvailableRoleException(String message, Throwable cause) {
        super(message, cause);
    }
}
