package com.meeting.sport.app.user;

public record UserResponse(
        Long id,
        String firstname,
        String lastname,
        int age
) {
}
