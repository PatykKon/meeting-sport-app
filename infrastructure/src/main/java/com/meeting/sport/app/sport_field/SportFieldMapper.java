package com.meeting.sport.app.sport_field;

import com.meeting.sport.app.dto.SportFieldDTO;
import com.meeting.sport.app.dto.SportFieldResponse;
import com.meeting.sport.app.sport_event.SportEventMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring", uses = {SportEventMapper.class})
public interface SportFieldMapper {

    @Mapping(target = "sportEventDTOS", source = "sportEvents")
    SportFieldDTO entityToDTO(SportFieldEntity sportFieldEntity);

    @Mapping(target = "fieldSpace", source = "fieldSpace")
    @Mapping(target = "address.city", source = "city")
    @Mapping(target = "address.street", source = "street")
    @Mapping(target = "address.number", source = "number")
    @Mapping(target = "sportEvents", source = "sportEventDTOS")
    SportField DTOToModel(SportFieldDTO sportFieldDTO);

    @Mapping(target = "spaceField", source = "fieldSpace")
    @Mapping(target = "city", source = "address.city")
    @Mapping(target = "street", source = "address.street")
    @Mapping(target = "number", source = "address.number")
    @Mapping(target = "sportEvents", source = "sportEvents")
    SportFieldEntity modelToEntity(SportField sportField);

    SportFieldResponse entityToResponse(SportFieldEntity sportFieldEntity);
}
