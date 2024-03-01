package com.meeting.sport.app;

import java.time.LocalDateTime;

public record BookingRequest(
        LocalDateTime startDateGame,
        Integer gameTime) {
}
