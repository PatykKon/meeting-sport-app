package com.meeting.sport.app.event;

import com.meeting.sport.app.dto.SportFieldResponse;
import com.meeting.sport.app.event.query.SportEventQueryFacade;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/auth/sport-field")
class FieldQueryAPI {

    private final SportEventQueryFacade sportEventQuery;

    @GetMapping("/all")
    List<SportFieldResponse> getSportFields(){
        return sportEventQuery.getSportFields();
    }
    @GetMapping("/event/{eventId}")
    SportFieldResponse getSportFieldForEvent(@PathVariable Long eventId){
        return sportEventQuery.getSportFieldByEvent(eventId);
    }
}
