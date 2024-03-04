package com.meeting.sport.app.sport_event;

import lombok.Builder;

@Builder
public record GameUserResponse(
        Long id,
        GameRole gameRole,
        boolean isAvailable
) {
}
