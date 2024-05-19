package com.meeting.sport.app.sport_field;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/auth/sport-field")
class SportFieldQueryAPI {

    private final SportFieldQuery sportFieldQuery;

    @GetMapping("/all")
    List<SportFieldResponse> getSportFields(){
        return sportFieldQuery.getSportFields();
    }
    @GetMapping("/event/{fieldId}")
    SportFieldResponse getSportFieldForEvent(@PathVariable Long fieldId){
        return sportFieldQuery.getSportFieldByEvent(fieldId);
    }
}
