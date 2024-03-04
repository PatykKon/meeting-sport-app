package com.meeting.sport.app.sport_event;

import lombok.Builder;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Builder
class GameUser {

    private Long id;
    private final GameRole gameRole;
    private final boolean isAvailable;
    private SportEvent sportEvent;


    public GameUser(Long id, GameRole gameRole, boolean isAvailable, SportEvent sportEvent) {
        this.id = id;
        this.gameRole = gameRole;
        this.isAvailable = isAvailable;
        this.sportEvent = sportEvent;
    }

    GameUser(GameRole gameRole, SportEvent sportEvent) {
        this.gameRole = gameRole;
        this.isAvailable = true;
        this.sportEvent = sportEvent;
    }

    public static List<GameUser> crateGameUsers(List<GameRole> gameRoles,SportEvent sportEvent) {
        List<GameUser> gameRoleList = new ArrayList<>();

        gameRoles.forEach(gameRole -> gameRoleList.add(new GameUser(gameRole,sportEvent)));
        return gameRoleList;

    }
}
