package com.meeting.sport.app.dto;

import com.meeting.sport.app.sport_event.GameRole;
import com.meeting.sport.app.user.UserResponse;
import lombok.Builder;

import java.util.List;

@Builder
public record EventRoleResponse(
        Long id,
        GameRole gameRole,
        boolean isAvailable,

        UserResponse userResponse
) {
}
