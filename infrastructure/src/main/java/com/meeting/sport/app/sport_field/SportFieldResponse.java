package com.meeting.sport.app.sport_field;

import lombok.Builder;

@Builder
public record SportFieldResponse(
        FieldType fieldType,
        FieldSpace fieldSpace,
        String city,
        String street,
        String number
) {
}
