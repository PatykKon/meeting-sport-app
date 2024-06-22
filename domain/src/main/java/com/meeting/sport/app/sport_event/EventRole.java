package com.meeting.sport.app.sport_event;

class EventRole {

    private Long id;
    private GameRole gameRole;
    private SportEvent sportEvent;
    private Long userId;
    private boolean isAvailable;

    private EventRole() {
    }

    EventRole(Long id, GameRole gameRole, SportEvent sportEvent, boolean isAvailable, Long userId) {
        this.id = id;
        this.gameRole = gameRole;
        this.sportEvent = sportEvent;
        this.isAvailable = isAvailable;
        this.userId = userId;
    }

    static EventRole crateAvailableEventRole(String gameRole, SportEvent sportEvent) {
        return new EventRole(null, GameRole.valueOf(gameRole), sportEvent, true, null);
    }

    void assignToEvent(Long userId) {
        this.userId = userId;
        changeRoleAvailability();
    }

    void leaveEvent() {
        this.userId = null;
        changeRoleAvailability();
    }
    private void changeRoleAvailability() {
        this.isAvailable = !isAvailable;
    }

    Long getId() {
        return id;
    }

    GameRole getGameRole() {
        return gameRole;
    }

    boolean isAvailable() {
        return isAvailable;
    }

    SportEvent getSportEvent() {
        return sportEvent;
    }

    Long getUserId() {
        return userId;
    }
}
