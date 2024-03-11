package com.meeting.sport.app.event.query;

import com.meeting.sport.app.dto.SportEventResponse;
import com.meeting.sport.app.sport_event.SportEventEntity;
import com.meeting.sport.app.sport_event.SportEventMapper;
import com.meeting.sport.app.sport_event.SportEventRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class GetSportEvent {
    private final SportEventRepository sportEventRepository;
    private final SportEventMapper sportEventMapper;

    public List<SportEventResponse> getEvent(){
       return sportEventRepository.getAll().stream().map(sportEventMapper::entityToResponse).toList();
    }
}
