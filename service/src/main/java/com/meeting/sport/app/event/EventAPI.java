package com.meeting.sport.app.event;


import com.meeting.sport.app.dto.SportEventDTO;
import com.meeting.sport.app.dto.SportEventResponse;
import com.meeting.sport.app.event.command.*;
import com.meeting.sport.app.event.handler.EventFacade;
import com.meeting.sport.app.event.query.GetSportEvent;
import com.meeting.sport.app.sport_event.SportEventRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/sport-event")
class EventAPI {

    private final EventFacade eventFacade;
    private final GetSportEvent getSportEvent;
    private final SportEventRepository sportEventRepository;
    @Autowired
    EventAPI(EventFacade eventFacade, GetSportEvent getSportEvent, SportEventRepository sportEventRepository) {
        this.eventFacade = eventFacade;
        this.getSportEvent = getSportEvent;
        this.sportEventRepository = sportEventRepository;
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


    //for test
    @GetMapping
    List<SportEventResponse> getEvents(){
        return getSportEvent.getEvent();
    }

}
