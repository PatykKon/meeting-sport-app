package com.meeting.sport.app.sport_event;

import com.meeting.sport.app.sport_event.command.*;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("api/auth/sport-event")
class SportEventAPI {

    private final CreateSportEventHandler createSportEventHandler;
    private final AssignEventToPlaceHandler assignEventToPlaceHandler;
    private final CreateGameRoleHandler createGameRoleHandler;
    private final JoinEventHandler joinEventHandler;
    private final LeaveEventHandler leaveEventHandler;

    @PostMapping("/create")
    Long createEvent(@RequestBody CreateSportEventCommand command) {
        return createSportEventHandler.handle(command);
    }


    @PostMapping("/assign-to-field")
    Long assignEventToPlace(@RequestBody AssignEventToPlaceCommand command) {
        return assignEventToPlaceHandler.handle(command);
    }

    @PostMapping("/game-role")
    Long createGameRole(@RequestBody CreateGameRoleCommand command) {
        return createGameRoleHandler.handle(command);
    }

    @PostMapping("/join")
    Long joinEvent(@RequestBody JoinEventCommand command) {
        return joinEventHandler.handle(command);
    }

    @PutMapping("/leave")
    Long leaveEvent(@RequestBody LeaveEventCommand command) {
        return leaveEventHandler.handle(command);
    }
}
