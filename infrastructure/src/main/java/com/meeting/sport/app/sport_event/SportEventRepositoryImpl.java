package com.meeting.sport.app.sport_event;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;


@Repository

public class SportEventRepositoryImpl implements SportEventRepository {

    private final SportEventRepositoryJPA sportEventRepositoryJPA;
    private final SportEventMapper sportEventMapper;

    @Autowired
    public SportEventRepositoryImpl(SportEventRepositoryJPA sportEventRepositoryJPA, SportEventMapper sportEventMapper) {
        this.sportEventRepositoryJPA = sportEventRepositoryJPA;
        this.sportEventMapper = sportEventMapper;
    }

    @Override
    public void save(SportEvent sportEvent) {

        SportEventEntity sportEventToSave = sportEventMapper.sportEventToEntity(sportEvent);

        sportEventRepositoryJPA.save(sportEventToSave);
    }

//    @Override
//    public SportEventResponse getSportEvent(Long eventId) {
//        return sportEventRepositoryJPA.findById(eventId).map(SportEventMapper::toResponse).orElseThrow();
//    }
//
    @Override
    public SportEvent findById(Long eventId) {
        return sportEventMapper.sportEventToModel(sportEventRepositoryJPA.findById(eventId).orElseThrow());
    }
}
