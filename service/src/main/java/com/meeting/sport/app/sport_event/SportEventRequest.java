package com.meeting.sport.app.sport_event;

import java.time.LocalDateTime;
import java.util.List;

record SportEventRequest(
        String title,
        String description,
        int players,
        int minAge,
        LocalDateTime startTime,
        Integer gameTime,

        List<GameRole> gameRoles
) {
}
