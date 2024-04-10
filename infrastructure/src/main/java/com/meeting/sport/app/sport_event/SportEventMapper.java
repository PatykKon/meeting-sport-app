package com.meeting.sport.app.sport_event;

import com.meeting.sport.app.dto.SportEventResponse;
import com.meeting.sport.app.sport_field.SportFieldMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {EventRoleMapper.class, SportFieldMapper.class})
public interface SportEventMapper {

    @Mapping(source = "title.value", target = "title")
    @Mapping(source = "description.value", target = "description")
    @Mapping(source = "teamSize.teamSize", target = "players")
    @Mapping(source = "requiredAge.age", target = "minAge")
    @Mapping(source = "eventTime.startTime", target = "startTime")
    @Mapping(source = "eventTime.endTime", target = "endTime")
    @Mapping(source = "eventTime.gameTime", target = "gameTime")
    @Mapping(source = "eventRoles", target = "eventRoleEntities")
    @Mapping(source = "sportField", target = "sportFieldEntity")
    SportEventEntity modelToEntity(SportEvent sportEvent);

    @Mapping(source = "title", target = "title.value")
    @Mapping(source = "description", target = "description.value")
    @Mapping(source = "players", target = "teamSize.teamSize")
    @Mapping(source = "minAge", target = "requiredAge.age")
    @Mapping(source = "startTime", target = "eventTime.startTime")
    @Mapping(source = "gameTime", target = "eventTime.gameTime")
    @Mapping(source = "sportFieldEntity", target = "sportField")
    @Mapping(source = "eventRoleEntities", target = "eventRoles")
    SportEvent entityToModel(SportEventEntity sportEventEntity);


    @Mapping(source = "eventRoleEntities", target = "eventRoleResponse")
    @Mapping(source = "id", target = "id")
    @Mapping(source = "sportFieldEntity", target = "sportFieldResponse")
    SportEventResponse entityToResponse(SportEventEntity sportEvent);
}
