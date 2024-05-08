package com.meeting.sport.app.dto;

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
