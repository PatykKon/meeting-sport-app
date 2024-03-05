package com.meeting.sport.app.sport_event;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface SportEventMapper {


    SportEventEntity sportEventToEntity(SportEvent sportEvent);

    SportEvent sportEventToModel(SportEventEntity sportEvent);

}
