package com.meeting.sport.app.sport_event;

import com.meeting.sport.app.dto.SportEventDTO;
import com.meeting.sport.app.dto.SportEventResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {GameUserMapper.class})
public interface SportEventMapper {


    @Mapping(source = "gameUsersEntities", target = "gameUserDTOS")
    @Mapping(source = "sportField", target = "sportFieldDTO")
    @Mapping(source = "gamerEntities", target = "gamerDTOS")
    SportEventDTO entityToDTO(SportEventEntity sportEvent);

    @Mapping(source = "gameUserDTOS", target = "gameUsersEntities")
    @Mapping(source = "sportFieldDTO", target = "sportField")
    @Mapping(source = "gamerDTOS", target = "gamerEntities")
    SportEventEntity DTOToEntity(SportEventDTO sportEventDTO);

    @Mapping(source = "sportFieldDTO", target = "sportField")
    @Mapping(source = "title", target = "title.value")
    @Mapping(source = "description", target = "description.value")
    @Mapping(source = "players", target = "teamSize.teamSize")
    @Mapping(source = "minAge", target = "requiredAge.age")
    @Mapping(source = "startTime", target = "eventTime.startTime")
    @Mapping(source = "gameTime", target = "eventTime.gameTime")
    @Mapping(source = "gameUserDTOS", target = "gameUsers")
    @Mapping(source = "gamerDTOS", target = "gamers")
    SportEvent DTOToModel(SportEventDTO sportEventDTO);

    @Mapping(source = "sportField", target = "sportFieldDTO")
    @Mapping(source = "title.value", target = "title")
    @Mapping(source = "description.value", target = "description")
    @Mapping(source = "teamSize.teamSize", target = "players")
    @Mapping(source = "requiredAge.age", target = "minAge")
    @Mapping(source = "eventTime.startTime", target = "startTime")
    @Mapping(source = "eventTime.endTime", target = "endTime")
    @Mapping(source = "eventTime.gameTime", target = "gameTime")
    @Mapping(source = "gameUsers", target = "gameUserDTOS")
    @Mapping(source = "gamers", target = "gamerDTOS")
    SportEventDTO modelToDTO(SportEvent sportEvent);


    @Mapping(source = "gameUsersEntities", target = "gameUserResponse")
    @Mapping(source = "sportField", target = "sportFieldResponse")
    @Mapping(source = "gamerEntities", target = "gamerResponse")
    SportEventResponse entityToResponse(SportEventEntity sportEvent);
}
