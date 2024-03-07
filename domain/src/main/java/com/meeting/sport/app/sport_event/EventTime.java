package com.meeting.sport.app.sport_event;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class EventTime {

    private static final int MAX_PLAY_HOUR = 2;
    private static final int MIN_PLAY_HOUR = 1;

    LocalDateTime startTime;
    LocalDateTime endTime;
    Integer gameTime;

    EventTime(Integer gameTime,LocalDateTime startTime) {
        this.gameTime = checkGameTime(gameTime);
        this.startTime = startTime;
        this.endTime = startTime.plusHours(gameTime);
    }

    private Integer checkGameTime(Integer gameTime){
        if (gameTime > MAX_PLAY_HOUR) {
            throw new RuntimeException("You can't reserve field for more than 2 hours");
        }
        if (gameTime == null || gameTime < MIN_PLAY_HOUR) {
            throw new RuntimeException("time is not correct");
        }
        return gameTime;
    }
}
