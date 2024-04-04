package com.meeting.sport.app.sport_event;

import com.meeting.sport.app.dto.EventRoleResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface EventRoleMapper {

    @Mapping(source = "available", target = "isAvailable")
    EventRoleResponse entityToResponse(EventRoleEntity eventRoleEntity);

    @Mapping(source = "sportEvent.description.value", target = "sportEventEntity.description")
    @Mapping(source = "sportEvent.title.value", target = "sportEventEntity.title")
    @Mapping(source = "sportEvent.teamSize.teamSize", target = "sportEventEntity.players")
    @Mapping(source = "sportEvent.requiredAge.age", target = "sportEventEntity.minAge")
    @Mapping(source = "sportEvent.eventTime.startTime", target = "sportEventEntity.startTime")
    @Mapping(source = "sportEvent.eventTime.endTime", target = "sportEventEntity.endTime")
    @Mapping(source = "sportEvent.eventTime.gameTime", target = "sportEventEntity.gameTime")
    @Mapping(source = "available", target = "isAvailable")
    EventRoleEntity modelToEntity(EventRole eventRole);

    @Mapping(source = "sportEventEntity.description", target = "sportEvent.description.value")
    @Mapping(source = "sportEventEntity.title", target = "sportEvent.title.value")
    @Mapping(source = "sportEventEntity.players", target = "sportEvent.teamSize.teamSize")
    @Mapping(source = "sportEventEntity.minAge", target = "sportEvent.requiredAge.age")
    @Mapping(source = "sportEventEntity.startTime", target = "sportEvent.eventTime.startTime")
    @Mapping(source = "sportEventEntity.gameTime", target = "sportEvent.eventTime.gameTime")
    @Mapping(source = "available", target = "isAvailable")
    EventRole entityToModel(EventRoleEntity eventRoleEntity);
}
