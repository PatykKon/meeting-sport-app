package com.meeting.sport.app.sport_event;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@AllArgsConstructor
@Repository
public class SportEventRepositoryImpl implements SportEventRepository {

    private final SportEventRepositoryJPA sportEventRepositoryJPA;

    @Override
    public void save(SportEvent sportEvent) {
        sportEventRepositoryJPA.save(SportEventMapper.toEntity(sportEvent));

    }

    @Override
    public Optional<SportEventEntity> getSportEvent(Long eventId) {
        return sportEventRepositoryJPA.findById(eventId);
    }
}
