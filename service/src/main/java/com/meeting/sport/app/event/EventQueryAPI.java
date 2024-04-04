package com.meeting.sport.app.event;

import com.meeting.sport.app.dto.EventRoleResponse;
import com.meeting.sport.app.dto.SportEventResponse;
import com.meeting.sport.app.event.query.SportEventQueryFacade;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/auth/sport-event")
class EventQueryAPI {

    private final SportEventQueryFacade sportEventQuery;

    @GetMapping
    List<SportEventResponse> getEvents(){
        return sportEventQuery.getEvents();
    }

    @GetMapping("/{userId}")
    List<EventRoleResponse> getEventRoleForUser(@PathVariable long userId){
        return sportEventQuery.getUserEvents(userId);
    }
    @GetMapping("/event/{eventId}")
    SportEventResponse getSportEvent(@PathVariable long eventId){
        return sportEventQuery.getEventById(eventId);
    }

}
