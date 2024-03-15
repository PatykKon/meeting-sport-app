package com.meeting.sport.app.event.sport_field;

import com.meeting.sport.app.sport_field.SportField;

public interface SportFieldService {

    SportField getSportFieldById(Long sportFieldId);

    void save(SportField sportField);
}
