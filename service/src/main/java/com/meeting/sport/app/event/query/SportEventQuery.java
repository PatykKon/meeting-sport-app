package com.meeting.sport.app.event.query;

import com.meeting.sport.app.dto.EventRoleResponse;
import com.meeting.sport.app.dto.SportEventResponse;
import com.meeting.sport.app.dto.SportFieldResponse;
import com.meeting.sport.app.sport_event.*;
import com.meeting.sport.app.sport_field.SportFieldEntity;
import com.meeting.sport.app.sport_field.SportFieldMapper;
import com.meeting.sport.app.sport_field.SportFieldRepository;
import com.meeting.sport.app.sport_field.SportFieldRepositoryJPA;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
class SportEventQuery implements SportEventQueryFacade{

    private final SportEventRepository sportEventRepository;
    private final SportEventMapper sportEventMapper;
    private final EventRoleRepository eventRoleRepository;
    private final SportEventRepositoryJPA sportEventRepositoryJPA;
    private final SportFieldRepositoryJPA sportFieldRepository;
    private final SportFieldMapper sportFieldMapper;

    public List<SportEventResponse> getEvents(){
       return sportEventRepository.getAll().stream().map(sportEventMapper::entityToResponse).toList();
    }
    public List<EventRoleResponse> getUserEvents(long userId){
        return eventRoleRepository.getEventRoleByUser(userId);
    }

    public SportEventResponse getEventById(Long eventId){
        SportEventEntity eventEntity = sportEventRepositoryJPA.findById(eventId).orElseThrow();
        return sportEventMapper.entityToResponse(eventEntity);
    }
    public List<SportFieldResponse> getSportFields(){
        return sportFieldRepository.findAll().stream().map(sportFieldMapper::entityToResponse).toList();
    }
}
