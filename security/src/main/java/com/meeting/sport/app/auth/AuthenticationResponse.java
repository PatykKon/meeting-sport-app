package com.meeting.sport.app.auth;

import lombok.Builder;

@Builder
public record AuthenticationResponse(
        String accessToken,
        String refreshToken
) {
}
