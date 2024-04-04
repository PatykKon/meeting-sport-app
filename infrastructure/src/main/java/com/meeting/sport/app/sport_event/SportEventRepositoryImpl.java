package com.meeting.sport.app.sport_event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
class SportEventRepositoryImpl implements SportEventRepository {

    private final SportEventRepositoryJPA sportEventRepositoryJPA;
    private final SportEventMapper sportEventMapper;

    @Autowired
    public SportEventRepositoryImpl(SportEventRepositoryJPA sportEventRepositoryJPA, SportEventMapper sportEventMapper) {
        this.sportEventRepositoryJPA = sportEventRepositoryJPA;
        this.sportEventMapper = sportEventMapper;
    }

    @Override
    public Long save(SportEvent sportEvent) {
        SportEventEntity eventEntity = sportEventRepositoryJPA.save(sportEventMapper.modelToEntity(sportEvent));
        return eventEntity.getId();
    }

    @Override
    public SportEvent findById(Long eventId) {
        return sportEventMapper.entityToModel(sportEventRepositoryJPA.findById(eventId).orElseThrow());
    }

    @Override
    public List<SportEventEntity> getAll() {
        return sportEventRepositoryJPA.findAll();
    }
}
