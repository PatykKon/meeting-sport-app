package com.meeting.sport.app.sport_field;

import com.meeting.sport.app.dto.SportFieldResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface SportFieldMapper {

    @Mapping(target = "spaceField", source = "fieldSpace")
    @Mapping(target = "fieldType", source = "fieldType")
    @Mapping(target = "city", source = "address.city")
    @Mapping(target = "street", source = "address.street")
    @Mapping(target = "number", source = "address.number")
    SportFieldEntity modelToEntity(SportField sportField);

    @Mapping(target = "fieldSpace", source = "spaceField")
    @Mapping(target = "fieldType", source = "fieldType")
    @Mapping(target = "address.city", source = "city")
    @Mapping(target = "address.street", source = "street")
    @Mapping(target = "address.number", source = "number")
    SportField entityToModel(SportFieldEntity sportFieldEntity);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "fieldSpace", source = "spaceField")
    SportFieldResponse entityToResponse(SportFieldEntity sportFieldEntity);
}
