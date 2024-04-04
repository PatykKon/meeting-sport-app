package com.meeting.sport.app.event.sport_event;

import com.meeting.sport.app.sport_event.EventRole;
import com.meeting.sport.app.sport_event.GameRole;
import com.meeting.sport.app.sport_event.SportEvent;

public interface SportEventService {
    EventRole getAvailableEventRoleById(Long eventId, GameRole gameRole);

    SportEvent getEventById(Long eventId);

    Long saveEventRole(EventRole eventRole);

    Long saveEvent(SportEvent sportEvent);

    void checkUserExistInOtherEventInThisTime(Long eventId, Long userId);

    EventRole getUserEventRole(Long eventId, Long userId);
}
