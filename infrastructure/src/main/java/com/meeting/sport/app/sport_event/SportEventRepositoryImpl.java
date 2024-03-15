package com.meeting.sport.app.sport_event;

import com.meeting.sport.app.dto.SportEventDTO;
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
    public void save(SportEvent sportEvent) {
        sportEventRepositoryJPA.save(sportEventMapper.modelToEntity(sportEvent));
    }

    @Override
    public SportEventDTO findById(Long eventId) {
        return sportEventMapper.entityToDTO(sportEventRepositoryJPA.findById(eventId).orElseThrow());
    }

    @Override
    public List<SportEventEntity> getAll() {
        return sportEventRepositoryJPA.findAll();
    }
}
