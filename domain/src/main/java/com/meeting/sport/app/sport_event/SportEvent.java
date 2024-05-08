package com.meeting.sport.app.sport_event;

import com.meeting.sport.app.sport_field.SportField;
import com.meeting.sport.app.user.User;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;

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

    void leaveEvent(Long userId){
        EventRole eventRole = eventRoles
                .stream()
                .filter(e -> Objects.nonNull(e.getUserId()) && e.getUserId().equals(userId))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("Brak użytkownika o danym id:" + userId));

        eventRole.leaveEvent();
        changeStatus();
    }

    void changeStatus() {

        StatusCreator statusCreator = new StatusCreator(this);
        this.sportEventStatus = statusCreator.selectStatus();

    }

    void addEventRoles(EventRole eventRole) {
        if (eventRoles == null) {
            eventRoles = new ArrayList<>();
        }
        this.eventRoles.add(eventRole);
        eventRole.addSportEvent(this);
    }

    void assignSportField(SportField sportField) {
        this.sportField = sportField;
    }

    protected int getActivePlayers() {
        int gameRoles = getEventRoles().size();
        int availableGameRoles = getEventRoles().stream()
                .filter(EventRole::isAvailable)
                .toList()
                .size();
        return gameRoles - availableGameRoles;
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
