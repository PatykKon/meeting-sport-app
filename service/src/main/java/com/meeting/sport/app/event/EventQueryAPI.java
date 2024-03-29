package com.meeting.sport.app.event;

import com.meeting.sport.app.dto.EventRoleResponse;
import com.meeting.sport.app.dto.SportEventResponse;
import com.meeting.sport.app.event.query.SportEventQueryFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/auth/sport-event")
class EventQueryAPI {

    private final SportEventQueryFacade sportEventQuery;

    @Autowired
    public EventQueryAPI(SportEventQueryFacade sportEventQuery) {
        this.sportEventQuery = sportEventQuery;
    }

    @GetMapping
    List<SportEventResponse> getEvents(){
        return sportEventQuery.getEvents();
    }

    @GetMapping("/{userId}")
    List<EventRoleResponse> getEventRoleForUser(@PathVariable long userId){
        return sportEventQuery.getUserEvents(userId);
    }
}
