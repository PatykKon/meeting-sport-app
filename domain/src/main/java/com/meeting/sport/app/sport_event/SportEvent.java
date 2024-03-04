package com.meeting.sport.app.sport_event;

import com.meeting.sport.app.Gamer;
import com.meeting.sport.app.sport_field.SportField;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Builder
public class SportEvent {

    private final static int MAX_DESCRIPTION = 200;
    private final static int MAX_TITLE = 60;

    private final Long id;

    private final Title title;
    private final Description description;
    private final TeamSize teamSize;
    private final RequiredAge requiredAge;
    private final SportField sportField;
    private final List<GameUser> gameUsers;
    private EventTime eventTime;
    private List<Gamer> gamers;

    private SportEvent(Long id, Title title, Description description, TeamSize teamSize, RequiredAge requiredAge, SportField sportField,List<GameUser> gameUsers,EventTime eventTime,List<Gamer> gamers) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.teamSize = teamSize;
        this.requiredAge = requiredAge;
        this.sportField = sportField;
        this.gameUsers = gameUsers;
        this.eventTime = eventTime;
        this.gamers = gamers;
    }

    public static SportEvent create(String title,
                                    String description,
                                    int players,
                                    int minAge,
                                    SportField sportField,
                                    LocalDateTime startEvent,
                                    Integer gameTime) {

        Title gameTitle = new Title(title);
        Description gameDescription = new Description(description);
        TeamSize gameTeamSize = new TeamSize(players);
        RequiredAge requiredAge = new RequiredAge(minAge);
        EventTime eventTime = new EventTime(gameTime,startEvent);
        List<Gamer> gamerList = new ArrayList<>();
        List<GameUser> gameUserList = new ArrayList<>();
        Long id = 0L;

        return new SportEvent(id, gameTitle, gameDescription, gameTeamSize, requiredAge, sportField,gameUserList,eventTime,gamerList);
    }

    public void addGameUsers(List<GameUser> gameUsers){
        this.gameUsers.addAll(gameUsers);

    }
    void join(Gamer gamer, GameRole gameRole) {

        if(isAgeRequired(gamer.getAge()) && isAvailableRole(gameRole)){
            this.gamers.add(gamer);
        }else throw new RuntimeException("u can not join");

    }

    private boolean isAvailableRole(GameRole game){
        return this.getGameUsers().stream()
                .filter(GameUser::isAvailable)
                .anyMatch(gameUser -> gameUser.getGameRole() == game);
    }
    private boolean isAgeRequired(int age){
        return this.requiredAge.getAge() <= age;
    }

}
