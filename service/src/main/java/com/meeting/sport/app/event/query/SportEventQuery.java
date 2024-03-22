package com.meeting.sport.app.event.query;

import com.meeting.sport.app.dto.EventRoleResponse;
import com.meeting.sport.app.dto.SportEventResponse;
import com.meeting.sport.app.sport_event.EventRoleRepository;
import com.meeting.sport.app.sport_event.SportEventMapper;
import com.meeting.sport.app.sport_event.SportEventRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
class SportEventQuery implements SportEventQueryFacade{

    private final SportEventRepository sportEventRepository;
    private final SportEventMapper sportEventMapper;
    private final EventRoleRepository eventRoleRepository;

    public List<SportEventResponse> getEvents(){
       return sportEventRepository.getAll().stream().map(sportEventMapper::entityToResponse).toList();
    }
    public List<EventRoleResponse> getUserEvents(long userId){
        return eventRoleRepository.getEventRoleByUser(userId);
    }
}
