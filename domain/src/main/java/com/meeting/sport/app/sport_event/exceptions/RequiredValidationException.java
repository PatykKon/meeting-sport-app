package com.meeting.sport.app.sport_event.exceptions;

public class RequiredValidationException extends RuntimeException {
    public RequiredValidationException(String message) {
        super(message);
    }

}
