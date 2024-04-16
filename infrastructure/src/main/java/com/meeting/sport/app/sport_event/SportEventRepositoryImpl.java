package com.meeting.sport.app.sport_event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Repository
class SportEventRepositoryImpl implements SportEventRepository {

    private final SportEventRepositoryJPA sportEventRepositoryJPA;

    @Autowired
    public SportEventRepositoryImpl(SportEventRepositoryJPA sportEventRepositoryJPA) {
        this.sportEventRepositoryJPA = sportEventRepositoryJPA;
    }

    @Override
    public Long save(SportEvent sportEvent) {

        SportEventEntity entity = SportEventMapper1.modelToEntity(sportEvent);
        SportEventEntity eventEntity = sportEventRepositoryJPA.save(entity);
        return eventEntity.getId();
    }

    @Override
    public SportEvent findModelById(Long eventId) {

        SportEventEntity entity = findEntityById(eventId);
        return SportEventMapper1.entityToModel(entity);
    }
    @Override
    public SportEventEntity findEntityById(Long eventId){
        return sportEventRepositoryJPA.findById(eventId).orElseThrow();
    }

    @Override
    public List<SportEventEntity> findAllEntity() {
        return sportEventRepositoryJPA.findAll();
    }

    @Override
    public List<SportEvent> findAllSportEvent() {
        List<SportEventEntity> sportEventEntities = sportEventRepositoryJPA.findAll();
        return sportEventEntities.stream().map(SportEventMapper1::entityToModel).toList();
    }

    @Override
    public void saveAll(List<SportEvent> sportEvents) {
        List<SportEventEntity> sportEventEntities = sportEvents.stream().map(SportEventMapper1::modelToEntity).toList();
        sportEventRepositoryJPA.saveAll(sportEventEntities);
    }

    @Override
    public List<SportEvent> findAllSportEventByStatus(SportEventStatus sportEventStatus) {
        List<SportEventEntity> sportEventEntities = sportEventRepositoryJPA.findAllBySportEventStatus(sportEventStatus);

        if(sportEventEntities == null){
            return Collections.emptyList();
        }
        return sportEventEntities.stream().map(SportEventMapper1::entityToModel).toList();
    }
}
