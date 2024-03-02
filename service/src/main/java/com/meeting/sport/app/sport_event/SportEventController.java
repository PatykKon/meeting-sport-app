package com.meeting.sport.app.sport_event;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("api/sport-event/{sportFieldId}")
public class SportEventController {

    private SportEventService sportEventService;

    @PostMapping
    public void save(@PathVariable Long sportFieldId,
                     @RequestBody SportEventRequest sportEventRequest){
        sportEventService.makeSportEvent(sportFieldId,sportEventRequest);
    }

}
