package com.meeting.sport.app.sport_field;

import com.meeting.sport.app.sport_field.SportField;

interface SportFieldService {



    SportField getSportFieldById(Long sportFieldId);

    Long createSportField(
            FieldType fieldType,
            FieldSpace fieldSpace,
            String city,
            String street,
            String number);
}