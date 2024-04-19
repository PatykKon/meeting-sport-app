package com.meeting.sport.app.sport_event;

import com.meeting.sport.app.dto.EventRoleResponse;
import com.meeting.sport.app.dto.SportEventResponse;
import com.meeting.sport.app.user.dto.UserResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
class SportEventQuery  {

    private final QuerySportEventService querySportEventService;

    public List<SportEventResponse> getEvents() {
        return querySportEventService.getEvents();
    }

    public SportEventResponse getEventById(Long eventId) {
        return querySportEventService.getEventById(eventId);
    }

    public List<UserResponse> getEventUsers(Long eventId) {
        return querySportEventService.getEventUsers(eventId);
    }

    List<EventRoleResponse> getEventsForUser(Long userId){
        return querySportEventService.getEventsForUser(userId);
    }
}
