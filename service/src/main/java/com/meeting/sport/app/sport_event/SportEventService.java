package com.meeting.sport.app.sport_event;

import com.meeting.sport.app.sport_field.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
class SportEventService {

    private final SportEventRepository sportEventRepository;
    private final SportFieldRepository sportFieldRepository;

    public void makeSportEvent(Long sportFieldId, SportEventRequest sportEventRequest) {

        SportField sportField = sportFieldRepository.findById(sportFieldId);

        SportEvent sportEvent = SportEvent.create(sportEventRequest.title(), sportEventRequest.description(), sportEventRequest.players(), sportEventRequest.minAge(), sportField);
        sportEventRepository.save(sportEvent);
    }
}

