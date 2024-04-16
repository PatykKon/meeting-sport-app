package com.meeting.sport.app.user.dto;

public record UserResponse(
        Long id,
        String firstname,
        String lastname,
        int age
) {
}
