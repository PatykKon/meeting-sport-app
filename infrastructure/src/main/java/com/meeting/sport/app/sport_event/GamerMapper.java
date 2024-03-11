package com.meeting.sport.app.sport_event;

import com.meeting.sport.app.dto.GamerDTO;
import com.meeting.sport.app.dto.GamerResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring",uses = {SportEventMapper.class})
public interface GamerMapper {

    @Mapping(source = "sportEventDTOS", target = "sportEventEntities")
    GamerEntity DTOToEntity(GamerDTO dto);

    @Mapping(source = "sportEventEntities", target = "sportEventDTOS")
    GamerDTO entityToDTO(GamerEntity gamerEntity);

    @Mapping(source = "sportEventDTOS", target = "events")
    Gamer DTOToModel(GamerDTO dto);

    @Mapping(source = "events", target = "sportEventDTOS")
    GamerDTO modelToDTO(Gamer gamer);

    GamerResponse entityToResponse(GamerEntity gamerEntity);

}
