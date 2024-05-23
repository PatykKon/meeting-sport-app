package com.meeting.sport.app.sport_field;

interface SportFieldService {


    Long createSportField(
            String fieldType,
            String fieldSpace,
            String city,
            String street,
            String number);

    boolean isExist(Long id);
}
