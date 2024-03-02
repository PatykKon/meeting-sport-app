package com.meeting.sport.app.booking;

import lombok.Getter;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;


enum OpenFieldTime {
    WEEK(LocalTime.of(8, 0), LocalTime.of(18, 0)),
    WEEKEND(LocalTime.of(10, 0), LocalTime.of(22, 0));

    private final LocalTime openTime;
    private final LocalTime closeTime;

    OpenFieldTime(LocalTime openTime, LocalTime closeTime) {
        this.openTime = openTime;
        this.closeTime = closeTime;
    }
    public LocalTime getOpenTime() {
        return openTime;
    }

    public LocalTime getCloseTime() {
        return closeTime;
    }
}
