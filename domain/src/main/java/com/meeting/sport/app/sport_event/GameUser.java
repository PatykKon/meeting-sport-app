package com.meeting.sport.app.sport_event;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;


@Builder
public class GameUser {

    private Long id;
    private GameRole gameRole;
    private boolean isAvailable;
    private SportEvent sportEvent;


    public GameUser(Long id, GameRole gameRole, boolean isAvailable, SportEvent sportEvent) {
        this.id = id;
        this.gameRole = gameRole;
        this.isAvailable = isAvailable;
        this.sportEvent = sportEvent;
    }

    GameUser(GameRole gameRole) {
        this.gameRole = gameRole;
        this.isAvailable = true;
    }

    public void addSportEvent(SportEvent sportEvent){
        this.sportEvent = sportEvent;
    }

    public static List<GameUser> crateGameUsers(List<GameRole> gameRoles) {
        List<GameUser> gameRoleList = new ArrayList<>();

        gameRoles.forEach(gameRole -> gameRoleList.add(new GameUser(gameRole)));
        return gameRoleList;

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
    //    private GameUser submitRole(GameRole gameRole, List<GameUser> gameUsers) {
//        return gameUsers.stream()
//                .filter(gameUser -> gameUser.getGameRole() == gameRole && gameUser.isAvailable())
//                .findFirst()
//                .orElseThrow(() -> new NoSuchElementException("Brak dostępnego użytkownika gry dla roli: " + gameRole));
//    }

    public void changeAvailability(){
        this.isAvailable = !isAvailable;
    }
}
