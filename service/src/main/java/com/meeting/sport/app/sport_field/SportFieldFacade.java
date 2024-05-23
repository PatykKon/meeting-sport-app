package com.meeting.sport.app.sport_field;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class SportFieldFacade {

    SportFieldService sportFieldService;

    public void checkSportField(Long id){
        boolean isSportEventExist = sportFieldService.isExist(id);
        if(!isSportEventExist) {
            throw new RuntimeException("sport field with: " + id + "does not exist");
        }
    }
}
