package com.meeting.sport.app.sport_event;

import com.meeting.sport.app.sport_field.SportField;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Getter
@Builder
public class SportEvent {

    private final static int MAX_DESCRIPTION = 200;
    private final static int MAX_TITLE = 60;

    private Long id;

    private Title title;
    private Description description;
    private TeamSize teamSize;
    private RequiredAge requiredAge;
    private SportField sportField;
    private List<GameUser> gameUsers;
    private EventTime eventTime;
    private List<Gamer> gamers;

    public SportEvent() {
    }

    private SportEvent(Long id, Title title, Description description, TeamSize teamSize, RequiredAge requiredAge, List<GameUser> gameUsers, EventTime eventTime, List<Gamer> gamers) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.teamSize = teamSize;
        this.requiredAge = requiredAge;
        this.gameUsers = gameUsers;
        this.eventTime = eventTime;
        this.gamers = gamers;
    }

    public static SportEvent create(String title,
                                    String description,
                                    int players,
                                    int minAge,
                                    LocalDateTime startEvent,
                                    Integer gameTime) {

        Title gameTitle = new Title(title);
        Description gameDescription = new Description(description);
        TeamSize gameTeamSize = new TeamSize(players);
        RequiredAge requiredAge = new RequiredAge(minAge);
        EventTime eventTime = new EventTime(gameTime, startEvent);
        List<Gamer> gamerList = new ArrayList<>();
        List<GameUser> gameUserList = new ArrayList<>();


        return new SportEvent(null, gameTitle, gameDescription, gameTeamSize, requiredAge, gameUserList, eventTime, gamerList);
    }

    public void addGameUser(GameUser gameUser) {
        if (gameUsers == null) {
            gameUsers = new ArrayList<>();
        }
        this.gameUsers.add(gameUser);
        gameUser.addSportEvent(this);

    }

    public void joinToEvent(Gamer gamer, GameRole gameRole) {

        GameUser gameUser = submitRole(gameRole);
        gameUser.changeAvailability();
        checkGamerAge(gamer);
        addGamer(gamer);
    }

    private GameUser submitRole( GameRole gameRole) {
        return gameUsers.stream()
                .filter(gameUser -> gameUser.getGameRole() == gameRole && gameUser.isAvailable())
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("Brak dostępnego użytkownika gry dla roli: " + gameRole));
    }
    private void checkGamerAge(Gamer gamer){
        this.requiredAge.isUserAgeCorrect(gamer.getAge());
    }


    private void addGamer(Gamer gamer){
        if(this.gamers == null){
            this.gamers = new ArrayList<>();
        }
        this.gamers.add(gamer);
        gamer.addSportEvent(this);
    }
}