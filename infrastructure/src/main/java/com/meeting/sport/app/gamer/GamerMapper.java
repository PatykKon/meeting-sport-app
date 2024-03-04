package com.meeting.sport.app.gamer;

import com.meeting.sport.app.Gamer;
import com.meeting.sport.app.sport_event.SportEvent;
import com.meeting.sport.app.sport_event.SportEventEntity;
import com.meeting.sport.app.sport_event.SportEventMapper;

import java.util.List;

public class GamerMapper {


    public static GamerEntity toEntity(Gamer gamer) {

        List<SportEventEntity> sportEventEntity = SportEventMapper.toEntityList(gamer.getEvents());

        return GamerEntity.builder()
                .id(gamer.getId())
                .age(gamer.getAge())
                .sportEventEntities(sportEventEntity)
                .build();

    }
    public static List<GamerEntity> toEntityList(List<Gamer> gamers){
        return gamers.stream().map(GamerMapper::toEntity).toList();

    }
}
