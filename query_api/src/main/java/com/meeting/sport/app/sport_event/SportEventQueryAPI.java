package com.meeting.sport.app.sport_event;

import com.meeting.sport.app.dto.SportEventResponse;
import com.meeting.sport.app.user.dto.UserResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/auth/sport-event")
class SportEventQueryAPI {

    private final SportEventQuery sportEventQuery;

    @GetMapping
    List<SportEventResponse> getEvents() {
        return sportEventQuery.getEvents();
    }

    @GetMapping("/event/{eventId}")
    SportEventResponse getSportEvent(@PathVariable long eventId) {
        return sportEventQuery.getEventById(eventId);
    }

    @GetMapping("/users/{eventId}")
    List<UserResponse> getEventUsers(@PathVariable long eventId) {
        return sportEventQuery.getEventUsers(eventId);
    }


}
