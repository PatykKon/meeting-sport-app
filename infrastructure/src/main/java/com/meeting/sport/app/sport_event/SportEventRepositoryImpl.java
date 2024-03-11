package com.meeting.sport.app.sport_event;


import com.meeting.sport.app.dto.SportEventDTO;
import com.meeting.sport.app.dto.SportEventResponse;
import com.meeting.sport.app.dto.SportFieldResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

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
    public void save(SportEventDTO dto) {

        SportEventEntity sportEventToSave = sportEventMapper.DTOToEntity(dto);

        sportEventRepositoryJPA.save(sportEventToSave);
    }

    //    @Override
//    public SportEventResponse getSportEvent(Long eventId) {
//        return sportEventRepositoryJPA.findById(eventId).map(SportEventMapper::toResponse).orElseThrow();
//    }
//
    @Override
    public SportEventDTO findById(Long eventId) {
        return sportEventMapper.entityToDTO(sportEventRepositoryJPA.findById(eventId).orElseThrow());
    }

    @Override
    public List<SportEventEntity> getAll() {
       return sportEventRepositoryJPA.findAll();
    }
}
