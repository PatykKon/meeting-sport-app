package com.meeting.sport.app.sport_event;

import com.meeting.sport.app.user.User;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

public class EventRole {

    private Long id;
    private GameRole gameRole;
    private SportEvent sportEvent;
    private User user;
    private boolean isAvailable;

    public EventRole(Long id, GameRole gameRole, SportEvent sportEvent, User user, boolean isAvailable) {
        this.id = id;
        this.gameRole = gameRole;
        this.sportEvent = sportEvent;
        this.user = user;
        this.isAvailable = isAvailable;
    }

    public static List<EventRole> crateAvailableRoleForUsers(List<GameRole> gameRoles, SportEvent sportEvent) {

        if (!sportEvent.getEventRoles().isEmpty()) {
            throw new RuntimeException("this have already user role list");
        }
        if (gameRoles.size() != sportEvent.getNumberOfPlayers()) {
            throw new RuntimeException("game roles can not be less than declared number of players: " + sportEvent.getNumberOfPlayers());
        }
        List<EventRole> gameRoleList = new ArrayList<>();

        gameRoles.forEach(gameRole -> gameRoleList.add(crateAvailableEventRole(gameRole, sportEvent)));
        return gameRoleList;
    }

    public void assignUser(User user) {
        changeRoleAvailability();
        this.user = user;
    }
    public void leaveEvent(){
        this.user = null;
        changeRoleAvailability();
    }

    void addSportEvent(SportEvent sportEvent) {
        this.sportEvent = sportEvent;
    }

    private void changeRoleAvailability() {
        this.isAvailable = !isAvailable;
    }

    private static EventRole crateAvailableEventRole(GameRole gameRole, SportEvent sportEvent) {
        return new EventRole(null, gameRole, sportEvent, null, true);
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

    public User getUser() {
        return user;
    }
}
