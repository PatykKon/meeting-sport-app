package com.meeting.sport.app.sport_event;

import com.meeting.sport.app.dto.GameUserDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface GameUserMapper {


    @Mapping(source = "sportEventDTO", target = "sportEventEntity")
    GameUserEntity DTOToEntity(GameUserDTO gameUserDTO);

    @Mapping(source = "sportEventEntity", target = "sportEventDTO")
    GameUserDTO entityToDTO(GameUserEntity gameUser);

    GameUser DTOToModel(GameUserDTO gameUserDTO);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "sportEvent.description.value", target = "sportEventDTO.description")
    @Mapping(source = "sportEvent.title.value", target = "sportEventDTO.title")
    @Mapping(source = "sportEvent.teamSize.teamSize", target = "sportEventDTO.players")
    @Mapping(source = "sportEvent.requiredAge.age", target = "sportEventDTO.minAge")
    @Mapping(source = "sportEvent.eventTime.startTime", target = "sportEventDTO.startTime")
    @Mapping(source = "sportEvent.eventTime.endTime", target = "sportEventDTO.endTime")
    @Mapping(source = "sportEvent.eventTime.gameTime", target = "sportEventDTO.gameTime")
    GameUserDTO modelToDTO(GameUser gameUser);
}
