package com.meeting.sport.app.sport_event;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;


@Builder
@AllArgsConstructor
public class GameUser {

    private Long id;
    private GameRole gameRole;
    private boolean isAvailable;
    private SportEvent sportEvent;

    GameUser(GameRole gameRole, SportEvent sportEvent) {
        this.gameRole = gameRole;
        this.isAvailable = true;
        this.sportEvent = sportEvent;
    }

    public void addSportEvent(SportEvent sportEvent) {
        this.sportEvent = sportEvent;
    }

    public static List<GameUser> crateGameUsers(List<GameRole> gameRoles, SportEvent sportEvent) {


        if (!sportEvent.getGameUsers().isEmpty()) {
            throw new RuntimeException("this have already user role list");
        }

        List<GameUser> gameRoleList = new ArrayList<>();


        gameRoles.forEach(gameRole -> gameRoleList.add(new GameUser(gameRole, sportEvent)));
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
}
