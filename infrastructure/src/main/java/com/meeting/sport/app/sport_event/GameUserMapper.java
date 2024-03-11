package com.meeting.sport.app.sport_event;

import com.meeting.sport.app.dto.GameUserDTO;
import com.meeting.sport.app.dto.GameUserResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface GameUserMapper {


    @Mapping(source = "sportEventDTO", target = "sportEventEntity")
    @Mapping(source = "available", target = "isAvailable")
    GameUserEntity DTOToEntity(GameUserDTO gameUserDTO);

    @Mapping(source = "sportEventEntity", target = "sportEventDTO")
    @Mapping(source = "available", target = "isAvailable")
    GameUserDTO entityToDTO(GameUserEntity gameUser);

    @Mapping(source = "available", target = "isAvailable")
    @Mapping(source = "sportEventDTO.description", target = "sportEvent.description.value")
    @Mapping(source = "sportEventDTO.title", target = "sportEvent.title.value")
    @Mapping(source = "sportEventDTO.players", target = "sportEvent.teamSize.teamSize")
    @Mapping(source = "sportEventDTO.minAge", target = "sportEvent.requiredAge.age")
    @Mapping(source = "sportEventDTO.startTime", target = "sportEvent.eventTime.startTime")
    @Mapping(source = "sportEventDTO.gameTime", target = "sportEvent.eventTime.gameTime")
    GameUser DTOToModel(GameUserDTO gameUserDTO);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "sportEvent.description.value", target = "sportEventDTO.description")
    @Mapping(source = "sportEvent.title.value", target = "sportEventDTO.title")
    @Mapping(source = "sportEvent.teamSize.teamSize", target = "sportEventDTO.players")
    @Mapping(source = "sportEvent.requiredAge.age", target = "sportEventDTO.minAge")
    @Mapping(source = "sportEvent.eventTime.startTime", target = "sportEventDTO.startTime")
    @Mapping(source = "sportEvent.eventTime.endTime", target = "sportEventDTO.endTime")
    @Mapping(source = "sportEvent.eventTime.gameTime", target = "sportEventDTO.gameTime")
    @Mapping(source = "available", target = "isAvailable")
    GameUserDTO modelToDTO(GameUser gameUser);
    @Mapping(source = "available", target = "isAvailable")
    GameUserResponse entityToResponse(GameUserEntity gameUserEntity);
}
