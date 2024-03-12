package com.meeting.sport.app.sport_event;

import com.meeting.sport.app.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;

import java.util.ArrayList;
import java.util.List;


@Builder
@AllArgsConstructor
public class EventRole {

    private Long id;
    private GameRole gameRole;
    private boolean isAvailable;
    private SportEvent sportEvent;
    private User user;

    EventRole(GameRole gameRole, SportEvent sportEvent, User user) {
        this.gameRole = gameRole;
        this.isAvailable = true;
        this.sportEvent = sportEvent;
        this.user = user;
    }



    public void addSportEvent(SportEvent sportEvent) {
        this.sportEvent = sportEvent;
    }

    public static List<EventRole> crateGameUsers(List<GameRole> gameRoles, SportEvent sportEvent) {


        if (!sportEvent.getGameUsers().isEmpty()) {
            throw new RuntimeException("this have already user role list");
        }

        List<EventRole> gameRoleList = new ArrayList<>();



        gameRoles.forEach(gameRole -> gameRoleList.add(new EventRole(gameRole, sportEvent,null)));
        return gameRoleList;

    }

    //    private GameUser submitRole(GameRole gameRole, List<GameUser> gameUsers) {
//        return gameUsers.stream()
//                .filter(gameUser -> gameUser.getGameRole() == gameRole && gameUser.isAvailable())
//                .findFirst()
//                .orElseThrow(() -> new NoSuchElementException("Brak dostępnego użytkownika gry dla roli: " + gameRole));
//    }

    public void changeAvailability() {
        this.isAvailable = !isAvailable;
    }
    public void addGamer(User user){
        this.user = user;
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
