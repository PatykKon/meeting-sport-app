package com.meeting.sport.app.sport_field;

record SportFieldRequest(
        FieldType fieldType,
        FieldSpace fieldSpace,
        String city,
        String street,
        String number
) {
}
