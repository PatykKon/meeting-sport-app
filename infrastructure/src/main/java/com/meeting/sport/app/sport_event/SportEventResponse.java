package com.meeting.sport.app.sport_event;

import com.meeting.sport.app.sport_event.dto.EventRoleResponse;
import lombok.Builder;

import java.time.LocalDateTime;
import java.util.List;

@Builder
record SportEventResponse(

        Long id,
        String title,
        String description,
        LocalDateTime startTime,
        LocalDateTime endTime,
        Integer gameTime,
        int maxPlayers,
        int minAge,
        Long ownerId,
        List<EventRoleResponse> eventRoleResponse
) {
}
