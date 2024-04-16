package com.meeting.sport.app.sport_event;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class SportEventFacade {

    private final SportEventService sportEventService;

    public void updateEventSportStatus(){
        sportEventService.updateStatus();
    }
}
