package com.meeting.sport.app.sport_event;

import java.time.LocalDateTime;

class StatusCreator {

    private static final Integer ONE_HOUR_LEFT = 1;

    private LocalDateTime startTimeEvent;
    private int gameTime;
    private int minPlayers;
    private int activePlayers;

    private StatusCreator(){

    }

    StatusCreator(SportEvent sportEvent) {
        this.startTimeEvent = sportEvent.getEventTime().getStartTime();
        this.gameTime = sportEvent.getEventTime().getGameTime();
        this.minPlayers = sportEvent.getTeamSize().getMinPlayers();
        this.activePlayers = sportEvent.getActivePlayers();

    }

    SportEventStatus selectStatus() {
        LocalDateTime timeNow = LocalDateTime.now();

        if (isSportEventShouldBeCanceled(activePlayers, timeNow)) {
            return SportEventStatus.CANCELED;
        }
        if (isAfterEvent(timeNow)) {
            return SportEventStatus.COMPLETED;
        }
        if (isDuringEvent(timeNow)) {
            return SportEventStatus.DURING;
        }
        return SportEventStatus.COMING;
    }

    private boolean isSportEventShouldBeCanceled(int currentPlayers, LocalDateTime timeNow) {
        boolean isNumberOfPlayersInRange = currentPlayers < minPlayers;
        boolean isTimeToCheckNumberOfPlayers = timeNow.isAfter(startTimeEvent.minusHours(ONE_HOUR_LEFT));

        return isNumberOfPlayersInRange && isTimeToCheckNumberOfPlayers;

    }

    private boolean isAfterEvent(LocalDateTime timeNow) {
        return timeNow.isAfter(startTimeEvent.plusHours(gameTime));
    }

    private boolean isDuringEvent(LocalDateTime timeNow) {
        LocalDateTime eventEndTime = startTimeEvent.plusHours(gameTime);
        boolean isEventStarted = !timeNow.isBefore(startTimeEvent);
        boolean isEventNotEnded = timeNow.isBefore(eventEndTime);

        return isEventStarted && isEventNotEnded;
    }
}
