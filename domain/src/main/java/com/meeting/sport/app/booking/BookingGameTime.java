package com.meeting.sport.app.booking;


import lombok.AccessLevel;
import lombok.Getter;
import lombok.Value;


record BookingGameTime(
        Integer gameTime
) {
    private static final int MAX_PLAY_HOUR = 2;
    private static final int MIN_PLAY_HOUR = 1;

    BookingGameTime(Integer gameTime) {
        this.gameTime = gameTime;

        if (gameTime > MAX_PLAY_HOUR) {
            throw new RuntimeException("You can't reserve field for more than 2 hours");
        }
        if (gameTime == null || gameTime < MIN_PLAY_HOUR) {
            throw new RuntimeException("time is not correct");
        }

    }
}
