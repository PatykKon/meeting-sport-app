package com.meeting.sport.app.sport_event.exceptions;

public class JoinEventException extends RuntimeException {
    public JoinEventException(String message) {
        super(message);
    }

    public JoinEventException(String message, Throwable cause) {
        super(message, cause);
    }
}
