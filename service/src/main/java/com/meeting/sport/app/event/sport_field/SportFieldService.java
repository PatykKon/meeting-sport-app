package com.meeting.sport.app.event.sport_field;

import com.meeting.sport.app.sport_field.SportField;

public interface SportFieldService {

    Long save(SportField sportField);


    SportField getSportFieldById(Long sportFieldId);
}
