package com.meeting.sport.app.user;

public class RatingPoint {

    private final int value;

    public RatingPoint(int value) {
        if (value < 0) {
            throw new RuntimeException("Rating point value must be more than 0");
        }
        this.value = this.getValue() + value;
    }

    public int getValue() {
        return value;
    }
}