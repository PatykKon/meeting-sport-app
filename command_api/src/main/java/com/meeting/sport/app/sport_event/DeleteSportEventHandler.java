package com.meeting.sport.app.sport_event;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
class DeleteSportEventHandler {
    private final SportEventService sportEventService;

    void handle(Long eventId, Long userId) {

        sportEventService.deleteSportEvent(eventId, userId);
    }
}
