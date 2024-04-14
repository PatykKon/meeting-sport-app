package com.meeting.sport.app.sport_event;

import java.time.LocalDateTime;

class StatusCreator {

    private static final Integer ONE_HOUR_LEFT = 1;
    private final static LocalDateTime TIME_NOW = LocalDateTime.now();

    private final LocalDateTime startTimeEvent;
    private final int gameTime;
    private final int minPlayers;

    public StatusCreator(LocalDateTime startTimeEvent, int gameTime, int minPlayers) {
        this.startTimeEvent = startTimeEvent;
        this.gameTime = gameTime;
        this.minPlayers = minPlayers;
    }

    public SportEventStatus selectStatus(int currentPlayers) {
        if (isSportEventShouldBeCanceled(currentPlayers)) {
            return SportEventStatus.CANCELED;
        }
        if(isAfterEvent()){
            return SportEventStatus.COMPLETED;
        }
        if(isDuringEvent()){
            return SportEventStatus.DURING;
        }
        return SportEventStatus.COMING;
    }

    private boolean isSportEventShouldBeCanceled(int currentPlayers){
        boolean isNumberOfPlayersInRange = currentPlayers < minPlayers;
        boolean isTimeToCheckNumberOfPlayers = TIME_NOW.isAfter(startTimeEvent.minusHours(ONE_HOUR_LEFT));

        return isNumberOfPlayersInRange && isTimeToCheckNumberOfPlayers;

    }
    private boolean isAfterEvent(){
        return TIME_NOW.isAfter(startTimeEvent.plusHours(gameTime));
    }
    private boolean isDuringEvent(){
        boolean isEventTimeNow = TIME_NOW.isEqual(startTimeEvent);
        boolean isAfterStartEvent = TIME_NOW.isAfter(startTimeEvent);
        boolean isBeforeAndEvent = TIME_NOW.isBefore(startTimeEvent.plusHours(gameTime));

        return isEventTimeNow && isAfterStartEvent && isBeforeAndEvent;
    }
}
