package com.meeting.sport.app.sport_event;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@AllArgsConstructor
@Repository
public class SportEventRepositoryImpl implements SportEventRepository {

    private final SportEventRepositoryJPA sportEventRepositoryJPA;
    private final GameUserRepositoryJPA gameUserRepositoryJPA;

    @Override
    public void save(SportEvent sportEvent) {


        sportEventRepositoryJPA.save(SportEventMapper.toEntity(sportEvent));

    }

    @Override
    public void saveGameUser(GameUser gameUser) {
        gameUserRepositoryJPA.save(GameUserMapper.toEntity(gameUser));
    }

    @Override
    public SportEventResponse getSportEvent(Long eventId) {
        return sportEventRepositoryJPA.findById(eventId).map(SportEventMapper::toResponse).orElseThrow();
    }

    @Override
    public SportEvent findById(Long eventId) {
        return sportEventRepositoryJPA.findById(eventId).map(SportEventMapper::toModel).orElseThrow();
    }
}
