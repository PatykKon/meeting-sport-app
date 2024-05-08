package com.meeting.sport.app.dto;

import lombok.Builder;

@Builder
public record SportFieldResponse(
        Long id,
        String fieldType,
        String fieldSpace,
        String city,
        String street,
        String number
) {
}
