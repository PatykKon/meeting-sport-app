package com.meeting.sport.app.sport_event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Repository
class SportEventRepositoryImpl implements SportEventRepository {

    private final SportEventRepositoryJPA sportEventRepositoryJPA;

    @Autowired
    public SportEventRepositoryImpl(SportEventRepositoryJPA sportEventRepositoryJPA) {
        this.sportEventRepositoryJPA = sportEventRepositoryJPA;
    }

    @Override
    public Long save(SportEvent sportEvent) {

        SportEventEntity entity = SportEventMapper.modelToEntity(sportEvent);
        SportEventEntity eventEntity = sportEventRepositoryJPA.save(entity);
        return eventEntity.getId();
    }

    @Override
    public SportEvent findById(Long eventId) {

        SportEventEntity entity = sportEventRepositoryJPA.findById(eventId).orElseThrow(() -> new NoSuchElementException("No event with the given id:" + eventId));
        return SportEventMapper.entityToModel(entity);
    }

    @Override
    public List<SportEvent> findAllSportEvent() {
        List<SportEventEntity> sportEventEntities = sportEventRepositoryJPA.findAll();
        return sportEventEntities.stream().map(SportEventMapper::entityToModel).toList();
    }

    @Override
    public void saveAll(List<SportEvent> sportEvents) {
        List<SportEventEntity> sportEventEntities = sportEvents.stream().map(SportEventMapper::modelToEntity).toList();
        sportEventRepositoryJPA.saveAll(sportEventEntities);
    }

    @Override
    public List<SportEvent> findAllSportEventByTime(LocalDateTime time) {
        List<SportEventEntity> sportEventEntities = sportEventRepositoryJPA.findAllByStartTimeAfter(time)
                .orElse(Collections.emptyList());

        return sportEventEntities.stream()
                .map(SportEventMapper::entityToModel)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(SportEvent sportEvent) {
        SportEventEntity sportEventEntity = SportEventMapper.modelToEntity(sportEvent);
        sportEventRepositoryJPA.delete(sportEventEntity);
    }
}
