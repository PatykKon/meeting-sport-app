package com.meeting.sport.app.sport_event;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;

class SportEvent {

    private Long id;
    private Title title;
    private Description description;
    private Team team;
    private RequiredAge requiredAge;
    private EventTime eventTime;
    private Long ownerId;
    private List<EventRole> eventRoles;
    private Long sportFieldId;
    private SportEventStatus sportEventStatus;


    public SportEvent(Long id, Title title, Description description, Team team, RequiredAge requiredAge, List<EventRole> eventRoles, EventTime eventTime, Long ownerId, Long sportFieldId, SportEventStatus sportEventStatus) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.team = team;
        this.requiredAge = requiredAge;
        this.eventRoles = eventRoles;
        this.eventTime = eventTime;
        this.ownerId = ownerId;
        this.sportFieldId = sportFieldId;
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
        Team gameTeam = new Team(players, minPlayers);
        RequiredAge requiredAge = new RequiredAge(minAge);
        EventTime eventTime = new EventTime(gameTime, startEvent);
        List<EventRole> eventRoleList = new ArrayList<>();

        return new SportEvent(null, gameTitle, gameDescription, gameTeam, requiredAge, eventRoleList, eventTime, ownerId, null, SportEventStatus.COMING);
    }

    void updateEvent(Long userId,String description,String title,Integer minAge,Integer players,Integer minPlayers, Integer gameTime, LocalDateTime startEvent){
        checkOwner(userId);
        if(description != null){
            this.description = new Description(description);
        }
        if(title != null){
            this.title = new Title(title);
        }
        if(minAge != null){
            this.requiredAge = new RequiredAge(minAge);
        }
        if(players != null && minPlayers != null){
            this.team = new Team(players,minPlayers);
        }
        if(startEvent != null && gameTime != null){
            if(isAllRolesAvailable()) {
                this.eventTime = new EventTime(gameTime, startEvent);
            }
        }
    }

    private boolean isAllRolesAvailable(){
        return getEventRoles().stream()
                .allMatch(EventRole::isAvailable);
    }

    void leaveEvent(Long userId) {
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

    void joinToEvent(Long userId, String gameRole){

        EventRole selectedRole = getEventRoles()
                .stream()
                .filter(eventRole1 -> eventRole1.getGameRole().toString().equals(gameRole))
                .filter(EventRole::isAvailable)
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("Brak dostępnegej Roli"));

        if(getSportEventStatus() != SportEventStatus.COMING){
            throw new RuntimeException("can not join to this event!");
        }

        selectedRole.assignToEvent(userId);
    }

    void checkOwner(Long userId) {
        if (!ownerId.equals(userId)) {
            throw new RuntimeException("user with: " + userId + " is not owner!");
        }
    }

    void addEventRoles(EventRole eventRole) {
        this.eventRoles.add(eventRole);
    }

    void assignSportField(Long sportFieldId) {
        this.sportFieldId = sportFieldId;
    }

    int getActivePlayers() {
        int gameRoles = getEventRoles().size();
        int availableGameRoles = getEventRoles().stream()
                .filter(EventRole::isAvailable)
                .toList()
                .size();
        return gameRoles - availableGameRoles;
    }


    void checkTimeDeleteEvent(){
        if(!eventTime.isEventCanBeDeleted()){
            throw new RuntimeException("Event can not be deleted less than 4 hours to start");
        }
    }

    Long getId() {
        return id;
    }

    Title getTitle() {
        return title;
    }

    Description getDescription() {
        return description;
    }

    Team getTeamSize() {
        return team;
    }

    RequiredAge getRequiredAge() {
        return requiredAge;
    }

    EventTime getEventTime() {
        return eventTime;
    }

    List<EventRole> getEventRoles() {
        return eventRoles;
    }

    Long getOwnerId() {
        return ownerId;
    }
    Long getSportFieldId() {
        return sportFieldId;
    }

    SportEventStatus getSportEventStatus() {
        return sportEventStatus;
    }
}
