package com.meeting.sport.app.sport_event;

import java.time.LocalDateTime;
import java.util.Objects;

class EventTime {

    private static final int MAX_PLAY_HOUR = 2;
    private static final int MIN_PLAY_HOUR = 1;

    private final LocalDateTime startTime;
    private final LocalDateTime endTime;
    private final Integer gameTime;

    EventTime(Integer gameTime,LocalDateTime startTime) {
        this.gameTime = checkGameTime(gameTime);
        this.startTime = startTime;
        this.endTime = startTime.plusHours(gameTime);
    }

    public boolean isEventInTheSameTime(EventTime eventTime){
        return this.startTime.isBefore(eventTime.endTime) && eventTime.startTime.isBefore(this.endTime);
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

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public Integer getGameTime() {
        return gameTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EventTime eventTime = (EventTime) o;
        return Objects.equals(startTime, eventTime.startTime) && Objects.equals(gameTime, eventTime.gameTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(startTime, gameTime);
    }
}
