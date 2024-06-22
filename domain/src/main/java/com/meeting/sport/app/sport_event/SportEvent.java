package com.meeting.sport.app.sport_event;

import com.meeting.sport.app.sport_event.dto.EventRoleData;
import com.meeting.sport.app.sport_event.exceptions.*;

import java.time.LocalDateTime;
import java.util.*;

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

    private SportEvent(){

    }

    SportEvent(Long id, Title title, Description description, Team team, RequiredAge requiredAge, List<EventRole> eventRoles, EventTime eventTime, Long ownerId, Long sportFieldId, SportEventStatus sportEventStatus) {
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

    static SportEvent create(String title,
                                    String description,
                                    int players,
                                    int minAge,
                                    LocalDateTime startEvent,
                                    Integer gameTime,
                                    Long ownerId,
                                    int minPlayers) {

        return new SportEvent(
                null,
                new Title(title),
                new Description(description),
                new Team(players,minPlayers),
                new RequiredAge(minAge),
                new ArrayList<>(),
                new EventTime(gameTime,startEvent),
                ownerId,
                null,
                SportEventStatus.COMING
        );
    }

    void updateEvent(Long userId,String description,String title,Integer minAge,Integer players,Integer minPlayers, Integer gameTime, LocalDateTime startEvent) {
        verifyOwner(userId);
        if (description != null) {
            this.description = new Description(description);
        }
        if (title != null) {
            this.title = new Title(title);
        }
        if (minAge != null) {
            this.requiredAge = new RequiredAge(minAge);
        }
        if (players != null && minPlayers != null) {
            this.team = new Team(players, minPlayers);
        }
        if (startEvent != null && gameTime != null) {
            if (isAllRolesAvailable()) {
                this.eventTime = new EventTime(gameTime, startEvent);
            }
        }
    }

    void leaveEvent(Long userId) {
        EventRole eventRole = getUserRole(userId);
        eventRole.leaveEvent();
        changeStatus();
    }

    void changeStatus() {
        StatusCreator statusCreator = new StatusCreator(this);
        this.sportEventStatus = statusCreator.selectStatus();
    }

    void joinToEvent(Long userId, String gameRole){
        EventRole selectedRole = findAvailableRole(gameRole);
        verifyEventStatusToJoin();
        selectedRole.assignToEvent(userId);
    }

    void addEventRoles(List<EventRoleData> eventRoleDataList){
        List<EventRole> eventRoles = EventRoleCreator.createEventRoles(eventRoleDataList, this);
        eventRoles.forEach(this::addEventRole);
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
            throw new DeleteEventException("Event can not be deleted less than 4 hours to start");
        }
    }

    void verifyOwner(Long userId) {
        if (!ownerId.equals(userId)) {
            throw new NotOwnerException("user with: " + userId + " is not owner!");
        }
    }
    protected void addEventRole(EventRole eventRole) {
        this.eventRoles.add(eventRole);
    }

    private boolean isAllRolesAvailable(){
        return getEventRoles().stream()
                .allMatch(EventRole::isAvailable);
    }
    private void verifyEventStatusToJoin() {
        if (sportEventStatus != SportEventStatus.COMING) {
            throw new JoinEventException("Cannot join to event when event status is not coming!");
        }
    }

    private EventRole findAvailableRole(String gameRole) {
        return getEventRoles()
                .stream()
                .filter(er -> er.getGameRole().toString().equals(gameRole))
                .filter(EventRole::isAvailable)
                .findFirst()
                .orElseThrow(() -> new JoinEventException("No available role"));
    }

    private EventRole getUserRole(Long userId){
        return  eventRoles
                .stream()
                .filter(er -> Objects.nonNull(er.getUserId()) && er.getUserId().equals(userId))
                .findFirst()
                .orElseThrow(() -> new ExistUserException("No user with the given id:" + userId));
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
        return eventRoles.stream()
                .toList();
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
