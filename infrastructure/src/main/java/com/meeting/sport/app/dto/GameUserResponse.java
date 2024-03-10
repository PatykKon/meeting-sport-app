package com.meeting.sport.app.dto;

import com.meeting.sport.app.sport_event.GameRole;
import lombok.Builder;

@Builder
public record GameUserResponse(
        Long id,
        GameRole gameRole,
        boolean isAvailable
) {
}
