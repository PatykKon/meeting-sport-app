package com.meeting.sport.app.dto;

import com.meeting.sport.app.sport_field.FieldSpace;

import lombok.Builder;

import java.util.List;

@Builder
public record SportFieldDTO(
        Long id,
        String fieldType,
        FieldSpace fieldSpace,
        String city,
        String street,
        String number,
        List<SportEventDTO> sportEventDTOS
) {
}
