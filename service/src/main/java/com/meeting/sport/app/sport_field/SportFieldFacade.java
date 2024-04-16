package com.meeting.sport.app.sport_field;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class SportFieldFacade {

    SportFieldService sportFieldService;

    public SportField getSportFieldById(Long sportFieldId){
        return sportFieldService.getSportFieldById(sportFieldId);
    }
}
