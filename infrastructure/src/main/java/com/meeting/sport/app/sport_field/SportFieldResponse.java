package com.meeting.sport.app.sport_field;

import lombok.Builder;

@Builder
record SportFieldResponse(
        Long id,
        String fieldType,
        String fieldSpace,
        String city,
        String street,
        String number
) {
}
