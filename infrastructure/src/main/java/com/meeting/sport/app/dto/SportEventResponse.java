package com.meeting.sport.app.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;

import java.time.LocalDateTime;
import java.util.List;

@Builder
public record SportEventResponse(

        Long id,
        String title,
        String description,
        LocalDateTime startTime,
        LocalDateTime endTime,
        Integer gameTime,
        int maxPlayers,
        int minAge,
        Long ownerId,
        List<EventRoleResponse> eventRoleResponse,
        SportFieldResponse sportFieldResponse
) {
}
