package com.meeting.sport.app.sport_event;

import com.meeting.sport.app.dto.EventRoleResponse;
import com.meeting.sport.app.sport_field.SportField;

import java.time.LocalDateTime;
import java.util.List;

class EventRoleMapper {

    static EventRoleResponse entityToResponse(EventRoleEntity eventRoleEntity) {
        if (eventRoleEntity == null) {
            return null;
        }

        EventRoleResponse.EventRoleResponseBuilder eventRoleResponse = EventRoleResponse.builder();

        eventRoleResponse.isAvailable(eventRoleEntity.isAvailable());
        eventRoleResponse.id(eventRoleEntity.getId());
        eventRoleResponse.gameRole(eventRoleEntity.getGameRole().toString());
        eventRoleResponse.userId(eventRoleEntity.getUserId());
        eventRoleResponse.sportEventId(eventRoleEntity.sportEventEntity.getId());
//        eventRoleResponse.sportEventResponse(SportEventMapper1.entityToResponse(eventRoleEntity.getSportEventEntity()));

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
        if (eventRoleEntity == null) {
            return null;
        }

        SportEvent sportEvent = null;
        boolean isAvailable = false;
        Long id = null;
        GameRole gameRole = null;
        Long userId = null;

        sportEvent = sportEventEntityToSportEvent(eventRoleEntity.getSportEventEntity());
        isAvailable = eventRoleEntity.isAvailable();
        id = eventRoleEntity.getId();
        gameRole = eventRoleEntity.getGameRole();
        userId = eventRoleEntity.getUserId();

        EventRole eventRole = new EventRole(id, gameRole, sportEvent, isAvailable, userId);

        return eventRole;
    }

    private static String sportEventDescriptionValue(SportEvent sportEvent) {
        if (sportEvent == null) {
            return null;
        }
        Description description = sportEvent.getDescription();
        if (description == null) {
            return null;
        }
        String value = description.getValue();
        if (value == null) {
            return null;
        }
        return value;
    }

    private static String sportEventTitleValue(SportEvent sportEvent) {
        if (sportEvent == null) {
            return null;
        }
        Title title = sportEvent.getTitle();
        if (title == null) {
            return null;
        }
        String value = title.getValue();
        if (value == null) {
            return null;
        }
        return value;
    }

    private static int sportEventTeamSizeTeamSize(SportEvent sportEvent) {
        if (sportEvent == null) {
            return 0;
        }
        TeamSize teamSize = sportEvent.getTeamSize();
        if (teamSize == null) {
            return 0;
        }
        int teamSize1 = teamSize.getTeamSize();
        return teamSize1;
    }

    private static int sportEventRequiredAgeAge(SportEvent sportEvent) {
        if (sportEvent == null) {
            return 0;
        }
        RequiredAge requiredAge = sportEvent.getRequiredAge();
        if (requiredAge == null) {
            return 0;
        }
        int age = requiredAge.getAge();
        return age;
    }

    private static LocalDateTime sportEventEventTimeStartTime(SportEvent sportEvent) {
        if (sportEvent == null) {
            return null;
        }
        EventTime eventTime = sportEvent.getEventTime();
        if (eventTime == null) {
            return null;
        }
        LocalDateTime startTime = eventTime.getStartTime();
        if (startTime == null) {
            return null;
        }
        return startTime;
    }

    private static LocalDateTime sportEventEventTimeEndTime(SportEvent sportEvent) {
        if (sportEvent == null) {
            return null;
        }
        EventTime eventTime = sportEvent.getEventTime();
        if (eventTime == null) {
            return null;
        }
        LocalDateTime endTime = eventTime.getEndTime();
        if (endTime == null) {
            return null;
        }
        return endTime;
    }

    private static Integer sportEventEventTimeGameTime(SportEvent sportEvent) {
        if (sportEvent == null) {
            return null;
        }
        EventTime eventTime = sportEvent.getEventTime();
        if (eventTime == null) {
            return null;
        }
        Integer gameTime = eventTime.getGameTime();
        if (gameTime == null) {
            return null;
        }
        return gameTime;
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
        if (sportEventEntity == null) {
            return null;
        }

        String value = null;

        value = sportEventEntity.getDescription();

        Description description = new Description(value);

        return description;
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

    protected static TeamSize sportEventEntityToTeamSize(SportEventEntity sportEventEntity) {
        if (sportEventEntity == null) {
            return null;
        }

        int teamSize = 0;
        int minPlayers = 0;

        teamSize = sportEventEntity.getPlayers();
        minPlayers = sportEventEntity.getMinPlayers();

        return new TeamSize(teamSize, minPlayers);


    }

    protected static RequiredAge sportEventEntityToRequiredAge(SportEventEntity sportEventEntity) {
        if (sportEventEntity == null) {
            return null;
        }

        int age = 0;

        age = sportEventEntity.getMinAge();

        RequiredAge requiredAge = new RequiredAge(age);

        return requiredAge;
    }

    protected static EventTime sportEventEntityToEventTime(SportEventEntity sportEventEntity) {
        if (sportEventEntity == null) {
            return null;
        }

        LocalDateTime startTime = null;
        Integer gameTime = null;

        startTime = sportEventEntity.getStartTime();
        gameTime = sportEventEntity.getGameTime();

        EventTime eventTime = new EventTime(gameTime, startTime);

        return eventTime;
    }

    protected static SportEvent sportEventEntityToSportEvent(SportEventEntity sportEventEntity) {
        if (sportEventEntity == null) {
            return null;
        }

        Description description = null;
        Title title = null;
        TeamSize teamSize = null;
        RequiredAge requiredAge = null;
        EventTime eventTime = null;
        Long id = null;
        Long ownerId = null;

        description = sportEventEntityToDescription(sportEventEntity);
        title = sportEventEntityToTitle(sportEventEntity);
        teamSize = sportEventEntityToTeamSize(sportEventEntity);
        requiredAge = sportEventEntityToRequiredAge(sportEventEntity);
        eventTime = sportEventEntityToEventTime(sportEventEntity);
        id = sportEventEntity.getId();
        ownerId = sportEventEntity.getOwnerId();
        SportEventStatus sportEventStatus = sportEventEntity.getSportEventStatus();

        List<EventRole> eventRoles = null;
        SportField sportField = null;

        return new SportEvent(id, title, description, teamSize, requiredAge, eventRoles, eventTime, ownerId, sportField, sportEventStatus);

    }

//    new SportField(
//            sportEventEntity.getSportFieldEntity().getId(),
//                sportEventEntity.getSportFieldEntity().getFieldType(),
//                sportEventEntity.getSportFieldEntity().getSpaceField(),
//                new Address(
//            sportEventEntity.getSportFieldEntity().getCity(),
//                        sportEventEntity.getSportFieldEntity().getStreet(),
//                        sportEventEntity.getSportFieldEntity().getNumber())
//            );
}
