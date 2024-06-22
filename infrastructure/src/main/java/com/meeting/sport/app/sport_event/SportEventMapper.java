package com.meeting.sport.app.sport_event;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class SportEventMapper {

    static SportEventEntity modelToEntity(SportEvent sportEvent) {

        SportEventEntity.SportEventEntityBuilder sportEventEntity = SportEventEntity.builder();

        sportEventEntity.title(sportEventTitleValue(sportEvent));
        sportEventEntity.description(sportEventDescriptionValue(sportEvent));
        sportEventEntity.players(sportEventTeamSizeTeamSize(sportEvent));
        sportEventEntity.minPlayers(sportEventTeamSizeMinPlayer(sportEvent));
        sportEventEntity.minAge(sportEventRequiredAgeAge(sportEvent));
        sportEventEntity.startTime(sportEventEventTimeStartTime(sportEvent));
        sportEventEntity.endTime(sportEventEventTimeEndTime(sportEvent));
        sportEventEntity.gameTime(sportEventEventTimeGameTime(sportEvent));
        sportEventEntity.eventRoleEntities(eventRoleListToEventRoleEntityList(sportEvent.getEventRoles()));
        sportEventEntity.sportFieldId(sportEvent.getSportFieldId());
        sportEventEntity.id(sportEvent.getId());
        sportEventEntity.ownerId(sportEvent.getOwnerId());
        sportEventEntity.sportEventStatus(sportEvent.getSportEventStatus());

        return sportEventEntity.build();
    }

    static SportEvent entityToModel(SportEventEntity sportEventEntity) {

        Title title = sportEventEntityToTitle(sportEventEntity);
        Description description = sportEventEntityToDescription(sportEventEntity);
        Team team = sportEventEntityToTeamSize(sportEventEntity);
        RequiredAge requiredAge = sportEventEntityToRequiredAge(sportEventEntity);
        EventTime eventTime = sportEventEntityToEventTime(sportEventEntity);
        Long sportFieldId = sportEventEntity.getSportFieldId();
        List<EventRole> eventRoles = eventRoleEntityListToEventRoleList(sportEventEntity.getEventRoleEntities());
        Long id = sportEventEntity.getId();
        Long ownerId = sportEventEntity.getOwnerId();
        SportEventStatus sportEventStatus = sportEventEntity.getSportEventStatus();

        return new SportEvent(id, title, description, team, requiredAge, eventRoles, eventTime, ownerId, sportFieldId, sportEventStatus);

    }

    static SportEventResponse modelToResponse(SportEvent sportEvent) {

        SportEventResponse.SportEventResponseBuilder sportEventResponse = SportEventResponse.builder();

        sportEventResponse.eventRoleResponse(eventRoleEntityListToEventRoleResponseList(sportEvent.getEventRoles()));
        sportEventResponse.id(sportEvent.getId());
        sportEventResponse.title(sportEvent.getTitle().toString());
        sportEventResponse.description(sportEvent.getDescription().getValue());
        sportEventResponse.startTime(sportEvent.getEventTime().getStartTime());
        sportEventResponse.endTime(sportEvent.getEventTime().getEndTime());
        sportEventResponse.gameTime(sportEvent.getEventTime().getGameTime());
        sportEventResponse.minAge(sportEvent.getRequiredAge().getAge());
        sportEventResponse.maxPlayers(sportEvent.getTeamSize().getTeamSize());
        sportEventResponse.minPlayers(sportEvent.getTeamSize().getMinPlayers());
        sportEventResponse.ownerId(sportEvent.getOwnerId());

        return sportEventResponse.build();
    }

    private static String sportEventTitleValue(SportEvent sportEvent) {

        return sportEvent.getTitle().getValue();

    }

    private static String sportEventDescriptionValue(SportEvent sportEvent) {
        Description description = sportEvent.getDescription();
        return description.getValue();

    }

    private static int sportEventTeamSizeTeamSize(SportEvent sportEvent) {

        Team team = sportEvent.getTeamSize();
        return team.getTeamSize();

    }

    private static int sportEventTeamSizeMinPlayer(SportEvent sportEvent) {

        Team team = sportEvent.getTeamSize();
        return team.getMinPlayers();

    }

    private static int sportEventRequiredAgeAge(SportEvent sportEvent) {
        RequiredAge requiredAge = sportEvent.getRequiredAge();

        return requiredAge.getAge();
    }

    private static LocalDateTime sportEventEventTimeStartTime(SportEvent sportEvent) {

        EventTime eventTime = sportEvent.getEventTime();
        return eventTime.getStartTime();

    }

    private static LocalDateTime sportEventEventTimeEndTime(SportEvent sportEvent) {
        EventTime eventTime = sportEvent.getEventTime();

        return eventTime.getEndTime();

    }

    private static Integer sportEventEventTimeGameTime(SportEvent sportEvent) {

        EventTime eventTime = sportEvent.getEventTime();

        return eventTime.getGameTime();

    }

    protected static List<EventRoleEntity> eventRoleListToEventRoleEntityList(List<EventRole> list) {


        List<EventRoleEntity> list1 = new ArrayList<>();
        for (EventRole eventRole : list) {
            list1.add(EventRoleMapper.modelToEntity(eventRole));
        }

        return list1;
    }

    protected static Title sportEventEntityToTitle(SportEventEntity sportEventEntity) {



        String value = sportEventEntity.getTitle();

        return new Title(value);
    }

    protected static Description sportEventEntityToDescription(SportEventEntity sportEventEntity) {

        String value = sportEventEntity.getDescription();

        return new Description(value);

    }

    protected static Team sportEventEntityToTeamSize(SportEventEntity sportEventEntity) {

        int teamSize =  sportEventEntity.getPlayers();
        int minPlayers = sportEventEntity.getMinPlayers();

        return new Team(teamSize, minPlayers);
    }

    protected static RequiredAge sportEventEntityToRequiredAge(SportEventEntity sportEventEntity) {

        int age = sportEventEntity.getMinAge();

        return new RequiredAge(age);

    }

    protected static EventTime sportEventEntityToEventTime(SportEventEntity sportEventEntity) {


        LocalDateTime startTime = sportEventEntity.getStartTime();
        Integer gameTime = sportEventEntity.getGameTime();
        LocalDateTime endTime = sportEventEntity.getEndTime();

        return new EventTime(gameTime, startTime, endTime);
    }

    protected static List<EventRole> eventRoleEntityListToEventRoleList(List<EventRoleEntity> list) {

        return list.stream()
                .map(EventRoleMapper::entityToModel)
                .collect(Collectors.toList());
    }

    protected static List<EventRoleResponse> eventRoleEntityListToEventRoleResponseList(List<EventRole> list) {

        return list.stream()
                .map(EventRoleMapper::modelToResponse)
                .toList();
    }
}
