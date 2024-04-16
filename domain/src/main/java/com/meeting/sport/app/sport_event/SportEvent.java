package com.meeting.sport.app.sport_event;

import com.meeting.sport.app.sport_field.SportField;
import com.meeting.sport.app.user.User;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class SportEvent {

    private Long id;
    private Title title;
    private Description description;
    private TeamSize teamSize;
    private RequiredAge requiredAge;
    private EventTime eventTime;
    private Long ownerId;
    private List<EventRole> eventRoles;
    private SportField sportField;
    private SportEventStatus sportEventStatus;


    public SportEvent(Long id, Title title, Description description, TeamSize teamSize, RequiredAge requiredAge, List<EventRole> eventRoles, EventTime eventTime, Long ownerId, SportField sportField, SportEventStatus sportEventStatus) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.teamSize = teamSize;
        this.requiredAge = requiredAge;
        this.eventRoles = eventRoles;
        this.eventTime = eventTime;
        this.ownerId = ownerId;
        this.sportField = sportField;
        this.sportEventStatus = sportEventStatus;

    }

    public static SportEvent create(String title,
                                    String description,
                                    int players,
                                    int minAge,
                                    LocalDateTime startEvent,
                                    Integer gameTime,
                                    Long ownerId,
                                    int minPlayers) {

        Title gameTitle = new Title(title);
        Description gameDescription = new Description(description);
        TeamSize gameTeamSize = new TeamSize(players, minPlayers);
        RequiredAge requiredAge = new RequiredAge(minAge);
        EventTime eventTime = new EventTime(gameTime, startEvent);
        List<EventRole> eventRoleList = new ArrayList<>();

        return new SportEvent(null, gameTitle, gameDescription, gameTeamSize, requiredAge, eventRoleList, eventTime, ownerId, null, SportEventStatus.COMING);
    }

    public void changeStatus() {

        int allRoles = getEventRoles().size();
        int allAvailableGameRoles = getEventRoles().stream().filter(EventRole::isAvailable).toList().size();
        int activePlayers = allRoles - allAvailableGameRoles;

        StatusCreator statusCreator = new StatusCreator(
                getEventTime().getStartTime(),
                getEventTime().getGameTime(),
                getTeamSize().getTeamSize()
        );

        this.sportEventStatus = statusCreator.selectStatus(activePlayers);
    }

    public void addGameRoles(EventRole eventRole) {
        if (eventRoles == null) {
            eventRoles = new ArrayList<>();
        }
        this.eventRoles.add(eventRole);
        eventRole.addSportEvent(this);
    }

    public void assignSportField(SportField sportField) {
        this.sportField = sportField;
    }

    public boolean isInTheSameTime(EventTime eventTime) {
        return this.eventTime.isEventInTheSameTime(eventTime);
    }

    int getNumberOfPlayers() {
        return getTeamSize().getTeamSize();
    }

    public void checkRequirements(User user) {
        this.requiredAge.isUserAgeCorrect(user.getAge());
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

    public EventTime getEventTime() {
        return eventTime;
    }

    public List<EventRole> getEventRoles() {
        return eventRoles;
    }

    public Long getOwnerId() {
        return ownerId;
    }

    public SportField getSportField() {
        return sportField;
    }

    public SportEventStatus getSportEventStatus() {
        return sportEventStatus;
    }
}
