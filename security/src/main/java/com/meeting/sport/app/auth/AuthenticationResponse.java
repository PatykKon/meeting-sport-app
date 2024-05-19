package com.meeting.sport.app.auth;

import lombok.Builder;

@Builder
record AuthenticationResponse(
        String accessToken,
        String refreshToken
) {
}
