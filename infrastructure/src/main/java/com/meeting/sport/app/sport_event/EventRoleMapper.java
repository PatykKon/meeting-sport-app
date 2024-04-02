package com.meeting.sport.app.sport_event;

import com.meeting.sport.app.dto.EventRoleDTO;
import com.meeting.sport.app.dto.EventRoleResponse;
import com.meeting.sport.app.user.UserMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring",uses = {UserMapper.class})
public interface EventRoleMapper {

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

    @Mapping(source = "available", target = "isAvailable")
    @Mapping(source = "userEntity.id", target = "userId")
    EventRoleResponse entityToResponse(EventRoleEntity eventRoleEntity);

    @Mapping(source = "sportEvent.description.value", target = "sportEventEntity.description")
    @Mapping(source = "sportEvent.title.value", target = "sportEventEntity.title")
    @Mapping(source = "sportEvent.teamSize.teamSize", target = "sportEventEntity.players")
    @Mapping(source = "sportEvent.requiredAge.age", target = "sportEventEntity.minAge")
    @Mapping(source = "sportEvent.eventTime.startTime", target = "sportEventEntity.startTime")
    @Mapping(source = "sportEvent.eventTime.endTime", target = "sportEventEntity.endTime")
    @Mapping(source = "sportEvent.eventTime.gameTime", target = "sportEventEntity.gameTime")
    @Mapping(source = "user", target = "userEntity")
    @Mapping(source = "available", target = "isAvailable")
    EventRoleEntity modelToEntity(EventRole eventRole);
}
