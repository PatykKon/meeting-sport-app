package com.meeting.sport.app;

import java.time.LocalDateTime;

import static com.meeting.sport.app.OpenFieldTime.WEEK;
import static com.meeting.sport.app.OpenFieldTime.WEEKEND;

public record BookingTime(LocalDateTime startTime, LocalDateTime endTime) {

    public BookingTime {

        if (WEEKEND.isWeekend() && WEEKEND.getCloseTime().isBefore(endTime.toLocalTime())) {
            throw new RuntimeException("koniec rezrwacji jest po zamnkniecu");
        }
        if (WEEKEND.isWeekend() && WEEKEND.getOpenTime().isAfter(startTime.toLocalTime())) {
            throw new RuntimeException("start rezwracji jest przed rozpoczeciem");
        }
        if (WEEK.isWeekend() && WEEK.getCloseTime().isBefore(endTime.toLocalTime())) {
            throw new RuntimeException("koniec rezrwacji jest po zamnkniecu");
        }
        if (WEEK.isWeekend() && WEEK.getOpenTime().isAfter(startTime.toLocalTime())) {
            throw new RuntimeException("start rezwracji jest przed rozpoczeciem");
        }
    }
}
