package com.meeting.sport.app.event.query;

import com.meeting.sport.app.dto.EventRoleResponse;
import com.meeting.sport.app.dto.SportEventResponse;
import com.meeting.sport.app.dto.SportFieldResponse;
import com.meeting.sport.app.sport_event.*;
import com.meeting.sport.app.sport_field.*;
import com.meeting.sport.app.user.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
class SportEventQuery implements SportEventQueryFacade{

    private final SportEventRepository sportEventRepository;
    private final SportEventMapper sportEventMapper;
    private final EventRoleRepository eventRoleRepository;
    private final SportEventRepositoryJPA sportEventRepositoryJPA;
    private final SportFieldRepositoryJPA sportFieldRepositoryJPA;
    private final SportFieldRepository sportFieldRepository;
    private final SportFieldMapper sportFieldMapper;
    private final UserRepositoryJPA userRepositoryJPA;
    private final UserMapper userMapper;


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
        return sportFieldRepositoryJPA.findAll().stream().map(sportFieldMapper::entityToResponse).toList();
    }
    public SportFieldResponse getSportFieldByEvent(long sportEventId){

        SportEvent sportEvent = sportEventRepository.findById(sportEventId);
        SportField sportField = sportEvent.getSportField();
        SportFieldEntity sportFieldEntity = sportFieldMapper.modelToEntity(sportField);

        return sportFieldMapper.entityToResponse(sportFieldEntity);

    }
    public List<UserResponse> getEventUsers(Long eventId){
        SportEvent sportEvent = sportEventRepository.findById(eventId);
        return sportEvent.getEventRoles().stream()
                .filter(er -> er.getUserId() != null)
                .map(eventRole -> userRepositoryJPA.findById(eventRole.getUserId())
                        .orElseThrow(() -> new RuntimeException("User not found for id:"  + eventRole.getUserId())))
                .map(userMapper::entityToResponse)
                .collect(Collectors.toList());

    }
}
