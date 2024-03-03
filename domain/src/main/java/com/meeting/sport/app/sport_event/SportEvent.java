package com.meeting.sport.app.sport_event;

import com.meeting.sport.app.sport_field.SportField;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class SportEvent {

    private final static int MAX_DESCRIPTION = 200;
    private final static int MAX_TITLE = 60;

    private final Long id;

    private final Title title;
    private final Description description;
    private final TeamSize teamSize;
    private final RequiredAge requiredAge;
    private final SportField sportField;
    private EventTime eventTime;

    private SportEvent(Long id, Title title, Description description, TeamSize teamSize, RequiredAge requiredAge, SportField sportField,EventTime eventTime) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.teamSize = teamSize;
        this.requiredAge = requiredAge;
        this.sportField = sportField;
        this.eventTime = eventTime;
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
        Long id = 0L;

        return new SportEvent(id, gameTitle, gameDescription, gameTeamSize, requiredAge, sportField,eventTime);
    }
}
