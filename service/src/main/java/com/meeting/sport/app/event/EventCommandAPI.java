package com.meeting.sport.app.event;

import com.meeting.sport.app.event.command.*;
import com.meeting.sport.app.event.handler.EventFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/auth/sport-event")
class EventCommandAPI {

    private final EventFacade eventFacade;

    @Autowired
    EventCommandAPI(EventFacade eventFacade) {
        this.eventFacade = eventFacade;
    }

    @PostMapping("/create")
    void createEvent(@RequestBody CreateSportEventCommand command) {
        eventFacade.createSportEvent(command);
    }

    @PostMapping("/add-field")
    void createEvent(@RequestBody AddSportFieldCommand command) {
        eventFacade.addSportField(command);
    }

    @PostMapping("/assign-to-field")
    void createEvent(@RequestBody AssignEventToPlaceCommand command) {
        eventFacade.assignEventToPlace(command);
    }

    @PostMapping("/game-role")
    void createEvent(@RequestBody CreateGameRoleCommand command) {
        eventFacade.createGameRole(command);
    }

    @PostMapping("/join")
    void createEvent(@RequestBody JoinEventCommand command) {
        eventFacade.joinEvent(command);
    }

    @PutMapping("/leave")
    void createEvent(@RequestBody LeaveEventCommand command) {
        eventFacade.leaveEvent(command);
    }
}
