package com.meeting.sport.app.sport_event;

import com.meeting.sport.app.dto.SportEventDTO;
import com.meeting.sport.app.dto.SportEventResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {EventRoleMapper.class})
public interface SportEventMapper {


    @Mapping(source = "eventRoleEntities", target = "eventRoleDTOS")
    @Mapping(source = "sportField", target = "sportFieldDTO")
    SportEventDTO entityToDTO(SportEventEntity sportEvent);

    @Mapping(source = "eventRoleDTOS", target = "eventRoleEntities")
    @Mapping(source = "sportFieldDTO", target = "sportField")
    SportEventEntity DTOToEntity(SportEventDTO sportEventDTO);

    @Mapping(source = "sportFieldDTO", target = "sportField")
    @Mapping(source = "title", target = "title.value")
    @Mapping(source = "description", target = "description.value")
    @Mapping(source = "players", target = "teamSize.teamSize")
    @Mapping(source = "minAge", target = "requiredAge.age")
    @Mapping(source = "startTime", target = "eventTime.startTime")
    @Mapping(source = "gameTime", target = "eventTime.gameTime")
    @Mapping(source = "eventRoleDTOS", target = "eventRoles")
    SportEvent DTOToModel(SportEventDTO sportEventDTO);

    @Mapping(source = "sportField", target = "sportFieldDTO")
    @Mapping(source = "title.value", target = "title")
    @Mapping(source = "description.value", target = "description")
    @Mapping(source = "teamSize.teamSize", target = "players")
    @Mapping(source = "requiredAge.age", target = "minAge")
    @Mapping(source = "eventTime.startTime", target = "startTime")
    @Mapping(source = "eventTime.endTime", target = "endTime")
    @Mapping(source = "eventTime.gameTime", target = "gameTime")
    @Mapping(source = "eventRoles", target = "eventRoleDTOS")
    SportEventDTO modelToDTO(SportEvent sportEvent);


    @Mapping(source = "eventRoleEntities", target = "eventRoleResponse")
    @Mapping(source = "sportField", target = "sportFieldResponse")
    SportEventResponse entityToResponse(SportEventEntity sportEvent);
}
