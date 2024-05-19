package com.meeting.sport.app.sport_event;

import java.time.LocalDateTime;
import java.util.Objects;

class EventTime {

    private static final int MAX_PLAY_HOUR = 2;
    private static final int MIN_PLAY_HOUR = 1;
    private static final int MIN_HOUR_BEFORE_START_TO_DELETE_EVENT = 4;
    private static final int MIN_HOUR_TO_CREATE_EVENT = 3;

    private final LocalDateTime startTime;
    private final LocalDateTime endTime;
    private final Integer gameTime;

    EventTime(Integer gameTime,LocalDateTime startTime) {
        this.startTime = startTime;
        this.gameTime = checkGameTime(gameTime);
        this.endTime = startTime.plusHours(gameTime);
    }

    EventTime(Integer gameTime,LocalDateTime startTime,LocalDateTime endTime) {
        this.startTime = startTime;
        this.gameTime = gameTime;
        this.endTime = endTime;
    }

    public boolean isEventInTheSameTime(EventTime eventTime){
        return this.startTime.isBefore(eventTime.endTime) && eventTime.startTime.isBefore(this.endTime);
    }

    boolean isEventCanBeDeleted(){
        LocalDateTime nowTime = LocalDateTime.now();
        return startTime.isAfter(nowTime.minusHours(MIN_HOUR_BEFORE_START_TO_DELETE_EVENT));
    }

    private Integer checkGameTime(Integer gameTime){
        if(startTime.isBefore(LocalDateTime.now().plusHours(MIN_HOUR_TO_CREATE_EVENT))){
            throw new RuntimeException("!you cannot create events: " + MIN_HOUR_TO_CREATE_EVENT + " hours before they start!");
        }
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
