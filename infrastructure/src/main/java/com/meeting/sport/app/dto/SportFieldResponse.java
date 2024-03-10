package com.meeting.sport.app.dto;

import com.meeting.sport.app.sport_field.FieldSpace;
import com.meeting.sport.app.sport_field.FieldType;
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
