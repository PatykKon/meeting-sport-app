package com.meeting.sport.app.shedulded;

import com.meeting.sport.app.sport_event.SportEventFacade;
import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class UpdateSportEventStatus {

    private final SportEventFacade sportEventFacade;
    private static final long HALF_HOUR = 1800000;

    @Scheduled(fixedRate = HALF_HOUR)
    public void updateStatus(){
       sportEventFacade.updateEventSportStatus();
    }
}
