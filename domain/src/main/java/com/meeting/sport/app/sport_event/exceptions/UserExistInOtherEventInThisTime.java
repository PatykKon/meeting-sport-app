package com.meeting.sport.app.sport_event.exceptions;

public class UserExistInOtherEventInThisTime extends RuntimeException {
    public UserExistInOtherEventInThisTime(String message) {
        super(message);
    }

    public UserExistInOtherEventInThisTime(String message, Throwable cause) {
        super(message, cause);
    }
}
