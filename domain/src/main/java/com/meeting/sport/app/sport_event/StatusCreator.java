package com.meeting.sport.app.sport_event;

import java.time.LocalDateTime;

class StatusCreator {

    private static final Integer ONE_HOUR_LEFT = 1;

    private final LocalDateTime startTimeEvent;
    private final int gameTime;
    private final int minPlayers;

    public StatusCreator(LocalDateTime startTimeEvent, int gameTime, int minPlayers) {
        this.startTimeEvent = startTimeEvent;
        this.gameTime = gameTime;
        this.minPlayers = minPlayers;
    }

    public SportEventStatus selectStatus(int currentPlayers) {
        LocalDateTime timeNow = LocalDateTime.now();

        if (isSportEventShouldBeCanceled(currentPlayers,timeNow)) {
            return SportEventStatus.CANCELED;
        }
        if(isAfterEvent(timeNow)){
            return SportEventStatus.COMPLETED;
        }
        if(isDuringEvent(timeNow)){
            return SportEventStatus.DURING;
        }
        return SportEventStatus.COMING;
    }

    private boolean isSportEventShouldBeCanceled(int currentPlayers,LocalDateTime timeNow){
        boolean isNumberOfPlayersInRange = currentPlayers < minPlayers;
        boolean isTimeToCheckNumberOfPlayers = timeNow.isAfter(startTimeEvent.minusHours(ONE_HOUR_LEFT));

        return isNumberOfPlayersInRange && isTimeToCheckNumberOfPlayers;

    }
    private boolean isAfterEvent(LocalDateTime timeNow){
        return timeNow.isAfter(startTimeEvent.plusHours(gameTime));
    }
    private boolean isDuringEvent(LocalDateTime timeNow){
        boolean isEventTimeNow = timeNow.isEqual(startTimeEvent);
        boolean isAfterStartEvent = timeNow.isAfter(startTimeEvent);
        boolean isBeforeAndEvent = timeNow.isBefore(startTimeEvent.plusHours(gameTime));

        return isEventTimeNow || isAfterStartEvent && isBeforeAndEvent;
    }
}
