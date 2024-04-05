package com.meeting.sport.app.sport_event;

import com.meeting.sport.app.user.User;
public class EventRole {

    private Long id;
    private GameRole gameRole;
    private SportEvent sportEvent;
    private Long userId;
    private boolean isAvailable;

    public EventRole(Long id, GameRole gameRole, SportEvent sportEvent, boolean isAvailable,Long userId) {
        this.id = id;
        this.gameRole = gameRole;
        this.sportEvent = sportEvent;
        this.isAvailable = isAvailable;
        this.userId = userId;
    }

    public static EventRole crateAvailableEventRole(GameRole gameRole, SportEvent sportEvent) {
        return new EventRole(null, gameRole, sportEvent, true, null);
    }

    public void assignToEvent(User user) {
        this.userId = user.getId();
        changeRoleAvailability();
    }
    public void leaveEvent(){
        this.userId = null;
        changeRoleAvailability();
    }

    void addSportEvent(SportEvent sportEvent) {
        this.sportEvent = sportEvent;
    }
    private void changeRoleAvailability() {
        this.isAvailable = !isAvailable;
    }

    public Long getId() {
        return id;
    }

    public GameRole getGameRole() {
        return gameRole;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public SportEvent getSportEvent() {
        return sportEvent;
    }

    public Long getUserId() {
        return userId;
    }
}
