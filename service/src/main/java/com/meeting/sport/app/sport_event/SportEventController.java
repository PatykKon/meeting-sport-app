package com.meeting.sport.app.sport_event;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("api/sport-event")
class SportEventController {

    private SportEventService sportEventService;

    @PostMapping("/{sportFieldId}")
    void save(@PathVariable Long sportFieldId,
                     @RequestBody SportEventRequest sportEventRequest){
        sportEventService.makeSportEvent(sportFieldId,sportEventRequest);
    }

    @GetMapping("/{eventId}")
    SportEventResponse getResponse(@PathVariable Long eventId){
        return sportEventService.getEvent(eventId);
    }


}
