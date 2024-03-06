package com.meeting.sport.app.sport_event;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
@Mapper(componentModel = "spring",uses = SportEventMapper.class)
public interface GameUserMapper {
    @Mapping(source = "id", target = "id")
    @Mapping(source = "gameRole", target = "gameRole")
    @Mapping(source = "available", target = "isAvailable")
    @Mapping(source = "sportEvent", target = "sportEventEntity")
    GameUserEntity toGameUserEntity(GameUser gameUser);
}
