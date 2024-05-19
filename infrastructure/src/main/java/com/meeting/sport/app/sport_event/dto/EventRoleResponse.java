package com.meeting.sport.app.sport_event.dto;

import lombok.Builder;

@Builder
public record EventRoleResponse(
        Long id,

        String  gameRole,
        boolean isAvailable,
        Long userId,

        Long sportEventId
) {
}
