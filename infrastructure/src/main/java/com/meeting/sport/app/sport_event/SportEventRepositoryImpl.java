package com.meeting.sport.app.sport_event;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@AllArgsConstructor
@Repository
public class SportEventRepositoryImpl implements SportEventRepository{

    private final SportEventRepositoryJPA sportEventRepositoryJPA;
    @Override
    public void save(SportEvent sportEvent) {
        sportEventRepositoryJPA.save(SportEventMapper.toEntity(sportEvent));

    }
}
