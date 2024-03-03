package com.meeting.sport.app.booking;

import com.meeting.sport.app.sport_field.SportField;

import java.time.LocalDateTime;

record BookingRequest(
        LocalDateTime startDateGame,
        Integer gameTime,
        SportField sportField
) {
}
