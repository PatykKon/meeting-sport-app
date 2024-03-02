package com.meeting.sport.app.sport_event;

import com.meeting.sport.app.sport_field.SportField;
import com.meeting.sport.app.sport_field.SportFieldRequest;

import java.util.List;

public record SportEventRequest(
        String title,
        String description,
        int players,
        int minAge,
        List<SportFieldRequest> sportFields
) {
}
