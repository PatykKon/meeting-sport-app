package com.meeting.sport.app.event.sport_event;

import com.meeting.sport.app.dto.EventRoleDTO;
import com.meeting.sport.app.sport_event.EventRole;
import com.meeting.sport.app.sport_event.EventRoleEntity;
import com.meeting.sport.app.sport_event.GameRole;
import com.meeting.sport.app.sport_event.SportEvent;

import java.util.List;

public interface SportEventService {
    EventRole getAvailableEventRoleById(Long eventId, GameRole gameRole);

    SportEvent getEventById(Long eventId);

    void saveEventRole(EventRole eventRole);

    void saveEvent(SportEvent sportEvent);

    void checkUserExistInOtherEventInThisTime(Long eventId, Long userId);


    EventRole getUserEventRole(Long eventId, Long userId);
}
