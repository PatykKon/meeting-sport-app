package com.meeting.sport.app.sport_field.dto;

import com.meeting.sport.app.sport_field.Address;
import com.meeting.sport.app.sport_field.FieldSpace;
import com.meeting.sport.app.sport_field.FieldType;
import lombok.Builder;

@Builder
public record SportFieldDTO(
        Long id,
        FieldType fieldType,
        FieldSpace fieldSpace,
        Address address
) {
}
