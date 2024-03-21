package com.meeting.sport.app.auth;

import com.meeting.sport.app.user.Role;
import lombok.Builder;

@Builder
public record RegisterRequest(
        String firstName,
        String lastName,

        Integer age,
        String email,
        String password,
        Role role
) {
}