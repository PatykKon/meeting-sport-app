package com.meeting.sport.app.sport_field;

import com.meeting.sport.app.sport_field.dto.SportFieldDTO;

interface SportFieldService {

    SportFieldDTO getSportFieldById(Long sportFieldId);

    Long createSportField(
            String fieldType,
            String fieldSpace,
            String city,
            String street,
            String number);
}
