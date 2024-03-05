package com.meeting.sport.app.sport_field;

import com.meeting.sport.app.sport_event.SportEventMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface SportFieldMapper {


//    @Mapping(target = "sportEventEntities", source = "sportEvents")
    SportFieldEntity toEntity(SportField model);

//    @Mapping(target = "sportEvents", source = "sportEventEntities")
    SportField toModel(SportFieldEntity entity);
}
