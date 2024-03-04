package com.meeting.sport.app.sport_event;

import com.meeting.sport.app.gamer.GamerEntity;
import com.meeting.sport.app.gamer.GamerMapper;
import com.meeting.sport.app.sport_field.SportField;
import com.meeting.sport.app.sport_field.SportFieldEntity;
import com.meeting.sport.app.sport_field.SportFieldMapper;

import java.util.List;

public class SportEventMapper {


    static SportEventEntity toEntity(SportEvent sportEvent){

        SportFieldEntity sportField = SportFieldMapper.toEntity(sportEvent.getSportField());
        List<GamerEntity> gamerEntities = GamerMapper.toEntityList(sportEvent.getGamers());



        List<GameUserEntity> gameUsers = GameUserMapper.toEntityList(sportEvent.getGameUsers());

       return SportEventEntity.builder()
                .id(sportEvent.getId())
                .title(sportEvent.getTitle().getTitle())
                .description(sportEvent.getDescription().getDescription())
                .minAge(sportEvent.getRequiredAge().getAge())
                .players(sportEvent.getTeamSize().getTeamSize())
                .sportFieldEntity(sportField)
                .startTime(sportEvent.getEventTime().getStartTime())
                .endTime(sportEvent.getEventTime().getEndTime())
                .gameTime(sportEvent.getEventTime().getGameTime())
                .gamers(gamerEntities)
                .gameUsers(gameUsers)
                .build();
    }

    public static List<SportEventEntity> toEntityList(List<SportEvent> sportEventList){
        return sportEventList.stream().map(SportEventMapper::toEntity).toList();
    }

    public static SportEventResponse toResponse(SportEventEntity entity){
        return SportEventResponse.builder()
                .gameTime(entity.getGameTime())
                .startTime(entity.getStartTime())
                .endTime(entity.getEndTime())
                .description(entity.getDescription())
                .title(entity.getTitle())
                .minAge(entity.getMinAge())
                .maxPlayers(entity.getPlayers())
                .sportField(SportFieldMapper.toResponse(entity.getSportFieldEntity()))
                .gameUserResponses(GameUserMapper.toResponseList(entity.getGameUsers()))
                .build();
    }

    public static SportEvent toModel(SportEventEntity entity){
        SportField sportField = SportFieldMapper.toModel(entity.getSportFieldEntity());

        return SportEvent.builder()
                .id(entity.getId())
                .eventTime(new EventTime(entity.getGameTime(),entity.getStartTime()))
                .title(new Title(entity.getTitle()))
                .description(new Description(entity.getDescription()))
                .teamSize(new TeamSize(entity.getPlayers()))
                .requiredAge(new RequiredAge(entity.getMinAge()))
                .sportField(sportField)
                .build();
    }
}
