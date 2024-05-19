package com.meeting.sport.app.sport_event;

import com.meeting.sport.app.sport_event.dto.EventRoleResponse;

import java.time.LocalDateTime;
import java.util.List;

class EventRoleMapper {

    static EventRoleResponse entityToResponse(EventRoleEntity eventRoleEntity) {

        EventRoleResponse.EventRoleResponseBuilder eventRoleResponse = EventRoleResponse.builder();

        eventRoleResponse.isAvailable(eventRoleEntity.isAvailable());
        eventRoleResponse.id(eventRoleEntity.getId());
        eventRoleResponse.gameRole(eventRoleEntity.getGameRole().toString());
        eventRoleResponse.userId(eventRoleEntity.getUserId());
        eventRoleResponse.sportEventId(eventRoleEntity.sportEventEntity.getId());

        return eventRoleResponse.build();
    }

    static EventRoleEntity modelToEntity(EventRole eventRole) {
        if (eventRole == null) {
            return null;
        }

        EventRoleEntity.EventRoleEntityBuilder eventRoleEntity = EventRoleEntity.builder();

        eventRoleEntity.sportEventEntity(sportEventToSportEventEntity(eventRole.getSportEvent()));
        eventRoleEntity.isAvailable(eventRole.isAvailable());
        eventRoleEntity.id(eventRole.getId());
        eventRoleEntity.gameRole(eventRole.getGameRole());
        eventRoleEntity.userId(eventRole.getUserId());

        return eventRoleEntity.build();
    }

    static EventRole entityToModel(EventRoleEntity eventRoleEntity) {

        SportEvent sportEvent = sportEventEntityToSportEvent(eventRoleEntity.getSportEventEntity());
        boolean isAvailable = eventRoleEntity.isAvailable();
        Long id = eventRoleEntity.getId();
        GameRole gameRole = eventRoleEntity.getGameRole();
        Long userId = eventRoleEntity.getUserId();

        return new EventRole(id, gameRole, sportEvent, isAvailable, userId);
    }

    private static String sportEventDescriptionValue(SportEvent sportEvent) {

        Description description = sportEvent.getDescription();

        return description.getValue();

    }

    private static String sportEventTitleValue(SportEvent sportEvent) {

        Title title = sportEvent.getTitle();

        return title.getValue();

    }

    private static int sportEventTeamSizeTeamSize(SportEvent sportEvent) {

        Team team = sportEvent.getTeamSize();

        return team.getTeamSize();
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

    protected static SportEventEntity sportEventToSportEventEntity(SportEvent sportEvent) {
        if (sportEvent == null) {
            return null;
        }

        SportEventEntity.SportEventEntityBuilder sportEventEntity = SportEventEntity.builder();

        sportEventEntity.description(sportEventDescriptionValue(sportEvent));
        sportEventEntity.title(sportEventTitleValue(sportEvent));
        sportEventEntity.players(sportEventTeamSizeTeamSize(sportEvent));
        sportEventEntity.minAge(sportEventRequiredAgeAge(sportEvent));
        sportEventEntity.startTime(sportEventEventTimeStartTime(sportEvent));
        sportEventEntity.endTime(sportEventEventTimeEndTime(sportEvent));
        sportEventEntity.gameTime(sportEventEventTimeGameTime(sportEvent));
        sportEventEntity.id(sportEvent.getId());
        sportEventEntity.ownerId(sportEvent.getOwnerId());

        return sportEventEntity.build();
    }

    protected static Description sportEventEntityToDescription(SportEventEntity sportEventEntity) {

        String value = sportEventEntity.getDescription();

        return new Description(value);
    }

    protected static Title sportEventEntityToTitle(SportEventEntity sportEventEntity) {
        if (sportEventEntity == null) {
            return null;
        }

        String value = null;

        value = sportEventEntity.getTitle();

        Title title = new Title(value);

        return title;
    }

    protected static Team sportEventEntityToTeamSize(SportEventEntity sportEventEntity) {

        int teamSize = sportEventEntity.getPlayers();
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

    protected static SportEvent sportEventEntityToSportEvent(SportEventEntity sportEventEntity) {

        Description description = sportEventEntityToDescription(sportEventEntity);
        Title title = sportEventEntityToTitle(sportEventEntity);
        Team team = sportEventEntityToTeamSize(sportEventEntity);
        RequiredAge requiredAge = sportEventEntityToRequiredAge(sportEventEntity);
        EventTime eventTime = sportEventEntityToEventTime(sportEventEntity);
        Long id = sportEventEntity.getId();
        Long ownerId = sportEventEntity.getOwnerId();
        SportEventStatus sportEventStatus = sportEventEntity.getSportEventStatus();

        List<EventRole> eventRoles = null;
        Long sportFieldId = null;

        return new SportEvent(id, title, description, team, requiredAge, eventRoles, eventTime, ownerId, sportFieldId, sportEventStatus);

    }
}
