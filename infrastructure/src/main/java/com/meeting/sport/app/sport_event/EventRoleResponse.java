package com.meeting.sport.app.sport_event;

import lombok.Builder;

@Builder
record EventRoleResponse(
        Long id,
        String  gameRole,
        boolean isAvailable,
        Long userId,
        Long sportEventId
) {
}
