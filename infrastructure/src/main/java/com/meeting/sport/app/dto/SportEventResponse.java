package com.meeting.sport.app.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;

import java.time.LocalDateTime;
import java.util.List;

@Builder
public record SportEventResponse(
        String title,
        String description,
        LocalDateTime startTime,
        LocalDateTime endTime,
        Integer gameTime,
        int maxPlayers,
        int minAge,
        SportFieldResponse sportFieldResponse,
        List<EventRoleResponse> eventRoleResponse


) {
}
