package com.meeting.sport.app.sport_event;

import com.meeting.sport.app.sport_field.SportFieldEntity;
import com.meeting.sport.app.sport_field.SportFieldMapper;

public class SportEventMapper {

    static SportEventEntity toEntity(SportEvent sportEvent){

        SportFieldEntity sportField = SportFieldMapper.toEntity(sportEvent.getSportField());

        return SportEventEntity.builder()
                .title(sportEvent.getTitle().getTitle())
                .description(sportEvent.getDescription().getDescription())
                .minAge(sportEvent.getRequiredAge().getAge())
                .players(sportEvent.getTeamSize().getTeamSize())
                .sportFieldEntity(sportField)
                .build();
    }
}
