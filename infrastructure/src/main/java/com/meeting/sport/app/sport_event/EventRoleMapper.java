package com.meeting.sport.app.sport_event;

import com.meeting.sport.app.dto.EventRoleDTO;
import com.meeting.sport.app.dto.EventRoleResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface EventRoleMapper {


    @Mapping(source = "sportEventDTO", target = "sportEventEntity")
    @Mapping(source = "available", target = "isAvailable")
    @Mapping(source = "userDTO", target = "userEntity")
    EventRoleEntity DTOToEntity(EventRoleDTO eventRoleDTO);

    @Mapping(source = "sportEventEntity", target = "sportEventDTO")
    @Mapping(source = "available", target = "isAvailable")
    @Mapping(source = "userEntity", target = "userDTO")
    EventRoleDTO entityToDTO(EventRoleEntity gameUser);

    @Mapping(source = "available", target = "isAvailable")
    @Mapping(source = "sportEventDTO.description", target = "sportEvent.description.value")
    @Mapping(source = "sportEventDTO.title", target = "sportEvent.title.value")
    @Mapping(source = "sportEventDTO.players", target = "sportEvent.teamSize.teamSize")
    @Mapping(source = "sportEventDTO.minAge", target = "sportEvent.requiredAge.age")
    @Mapping(source = "sportEventDTO.startTime", target = "sportEvent.eventTime.startTime")
    @Mapping(source = "sportEventDTO.gameTime", target = "sportEvent.eventTime.gameTime")
    @Mapping(source = "userDTO", target = "user")
    EventRole DTOToModel(EventRoleDTO eventRoleDTO);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "sportEvent.description.value", target = "sportEventDTO.description")
    @Mapping(source = "sportEvent.title.value", target = "sportEventDTO.title")
    @Mapping(source = "sportEvent.teamSize.teamSize", target = "sportEventDTO.players")
    @Mapping(source = "sportEvent.requiredAge.age", target = "sportEventDTO.minAge")
    @Mapping(source = "sportEvent.eventTime.startTime", target = "sportEventDTO.startTime")
    @Mapping(source = "sportEvent.eventTime.endTime", target = "sportEventDTO.endTime")
    @Mapping(source = "sportEvent.eventTime.gameTime", target = "sportEventDTO.gameTime")
    @Mapping(source = "user", target = "userDTO")
    @Mapping(source = "available", target = "isAvailable")
    EventRoleDTO modelToDTO(EventRole eventRole);
    @Mapping(source = "available", target = "isAvailable")
    EventRoleResponse entityToResponse(EventRoleEntity eventRoleEntity);
}
