package com.meeting.sport.app.sport_event;

import com.meeting.sport.app.sport_field.SportField;
import com.meeting.sport.app.user.User;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
public class SportEvent {

    private Long id;
    private Title title;
    private Description description;
    private TeamSize teamSize;
    private RequiredAge requiredAge;
    private SportField sportField;
    private List<EventRole> eventRoles;
    private EventTime eventTime;

    public SportEvent(Long id, Title title, Description description, TeamSize teamSize, RequiredAge requiredAge, SportField sportField, List<EventRole> eventRoles, EventTime eventTime) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.teamSize = teamSize;
        this.requiredAge = requiredAge;
        this.sportField = sportField;
        this.eventRoles = eventRoles;
        this.eventTime = eventTime;
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
        List<EventRole> eventRoleList = new ArrayList<>();

        return new SportEvent(null, gameTitle, gameDescription, gameTeamSize, requiredAge, null, eventRoleList, eventTime);
    }

    public void addGameRoles(EventRole eventRole) {
        if (eventRoles == null) {
            eventRoles = new ArrayList<>();
        }
        this.eventRoles.add(eventRole);
        eventRole.addSportEvent(this);
    }
    int getNumberOfPlayers(){
        return getTeamSize().getTeamSize();
    }

    public void checkRequirements(User user) {
        this.requiredAge.isUserAgeCorrect(user.getAge());
    }

    public void submitSportField(SportField sportField) {
        this.sportField = sportField;
    }

    public Long getId() {
        return id;
    }

    public Title getTitle() {
        return title;
    }

    public Description getDescription() {
        return description;
    }

    public TeamSize getTeamSize() {
        return teamSize;
    }

    public RequiredAge getRequiredAge() {
        return requiredAge;
    }

    public SportField getSportField() {
        return sportField;
    }

    public EventTime getEventTime() {
        return eventTime;
    }

    public List<EventRole> getEventRoles() {
        return eventRoles;
    }

}
