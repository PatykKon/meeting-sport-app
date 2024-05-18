package com.meeting.sport.app.sport_field;

import com.meeting.sport.app.sport_field.dto.SportFieldDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class SportFieldFacade {

    SportFieldService sportFieldService;

    public SportFieldDTO getSportFieldById(Long sportFieldId){
        return sportFieldService.getSportFieldById(sportFieldId);
    }
}
