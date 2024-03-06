package com.meeting.sport.app.sport_event;

import com.meeting.sport.app.sport_field.SportFieldMapper;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface SportEventMapper {

    @Mapping(source = "id", target = "id")
    @Mapping(source = "title.title", target = "title")
    @Mapping(source = "description.description", target = "description")
    @Mapping(source = "teamSize.teamSize", target = "players")
    @Mapping(source = "requiredAge.age", target = "minAge")
    @Mapping(source = "eventTime.startTime", target = "startTime")
    @Mapping(source = "eventTime.endTime", target = "endTime")
    @Mapping(source = "eventTime.gameTime", target = "gameTime")
    @Mapping(source = "sportField", target = "sportField")
    @Mapping(source = "gameUsers", target = "gameUsersEntities")
//    @Mapping(source = "gamers", target = "gamerEntities")

    SportEventEntity sportEventToEntity(SportEvent sportEvent);


    @InheritInverseConfiguration
    @Mapping(target = "gameTime", ignore = true)
    SportEvent sportEventToEntity(SportEventEntity entity);


//    @Mapping(source = "id", target = "id")
//    @Mapping(source = "title", target = "title.title")
//    @Mapping(source = "description", target = "description.description")
//    @Mapping(source = "players", target = "teamSize.teamSize")
//    @Mapping(source = "minAge", target = "requiredAge.age")
//    @Mapping(source = "startTime", target = "eventTime.startTime")
//    @Mapping(source = "endTime", target = "eventTime.endTime")
//    @Mapping(source = "gameTime", target = "eventTime.gameTime")
//    @Mapping(source = "sportField", target = "sportField")
//    @Mapping(source = "gameUsers", target = "gameUsers")
//    @Mapping(source = "gamers", target = "gamers")
//    SportEvent sportEventToModel(SportEventEntity sportEvent);


}
