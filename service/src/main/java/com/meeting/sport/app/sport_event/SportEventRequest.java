package com.meeting.sport.app.sport_event;

import java.time.LocalDateTime;

record SportEventRequest(
        String title,
        String description,
        int players,
        int minAge,
        LocalDateTime startTime,
        Integer gameTime
) {
}
