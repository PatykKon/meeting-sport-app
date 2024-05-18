package com.meeting.sport.app.auth;

import lombok.Builder;

@Builder
record AuthenticationRequest(
        String email,
        String password
) {
}
