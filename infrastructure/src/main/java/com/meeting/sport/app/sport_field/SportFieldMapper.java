package com.meeting.sport.app.sport_field;

import com.meeting.sport.app.sport_event.SportEventMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring",uses = SportEventMapper.class)
public interface SportFieldMapper {


    @Mapping(target = "id", source = "id")
    @Mapping(target = "fieldType", source = "fieldType")
    @Mapping(target = "spaceField", source = "fieldSpace")
    @Mapping(target = "city", source = "address.city")
    @Mapping(target = "street", source = "address.street")
    @Mapping(target = "number", source = "address.number")
    @Mapping(target = "sportEvents", source = "sportEvents")
    SportFieldEntity toEntity(SportField model);

//    @Mapping(target = "id", source = "id")
//    @Mapping(target = "fieldType", source = "fieldType")
//    @Mapping(target = "fieldSpace", source = "spaceField")
//    @Mapping(target = "address.city", source = "city")
//    @Mapping(target = "address.street", source = "street")
//    @Mapping(target = "address.number", source = "number")
//    @Mapping(target = "sportEvents", source = "sportEvents")

    SportField toModel(SportFieldEntity entity);
}
