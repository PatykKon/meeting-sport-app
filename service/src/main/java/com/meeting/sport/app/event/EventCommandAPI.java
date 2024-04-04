package com.meeting.sport.app.event;

import com.meeting.sport.app.event.command.*;
import com.meeting.sport.app.event.handler.EventFacade;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("api/auth/sport-event")
class EventCommandAPI {

    private final EventFacade eventFacade;

    @PostMapping("/create")
    Long createEvent(@RequestBody CreateSportEventCommand command) {
        return eventFacade.createSportEvent(command);
    }

    @PostMapping("/add-field")
    Long addSportField(@RequestBody AddSportFieldCommand command) {
        return eventFacade.addSportField(command);
    }

    @PostMapping("/assign-to-field")
    Long assignEventToPlace(@RequestBody AssignEventToPlaceCommand command) {
        return eventFacade.assignEventToPlace(command);
    }

    @PostMapping("/game-role")
    Long createGameRole(@RequestBody CreateGameRoleCommand command) {
        return eventFacade.createGameRole(command);
    }

    @PostMapping("/join")
    Long joinEvent(@RequestBody JoinEventCommand command) {
        return eventFacade.joinEvent(command);
    }

    @PutMapping("/leave")
    Long leaveEvent(@RequestBody LeaveEventCommand command) {
        return eventFacade.leaveEvent(command);
    }
}
