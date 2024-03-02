package com.meeting.sport.app.booking;

import lombok.Getter;

import java.time.LocalDateTime;

import static com.meeting.sport.app.booking.OpenFieldTime.WEEK;
import static com.meeting.sport.app.booking.OpenFieldTime.WEEKEND;

@Getter
class BookingTime {
    private final LocalDateTime startTime;
    private final LocalDateTime endTime;

    BookingTime(LocalDateTime startTime, LocalDateTime endTime) {
        checkReservationTime();
        this.startTime = startTime;
        this.endTime = endTime;
    }

    private void checkReservationTime() {
        if (isReservationTimeAfterClosed(WEEK, endTime)) {
            throw new RuntimeException("koniec rezrwacji jest po zamnkniecu");
        }
        if (isReservationTimeBeforeOpen(WEEK, startTime)) {
            throw new RuntimeException("start rezwracji jest przed rozpoczeciem");
        }
        if (isReservationTimeAfterClosed(WEEKEND, endTime)) {
            throw new RuntimeException("koniec rezrwacji jest po zamnkniecu");
        }
        if (isReservationTimeBeforeOpen(WEEKEND, startTime)) {
            throw new RuntimeException("start rezwracji jest przed rozpoczeciem");
        }
    }

    private boolean isReservationTimeAfterClosed(OpenFieldTime openFieldTime, LocalDateTime endTime) {
        return openFieldTime.getCloseTime().isBefore(endTime.toLocalTime());
    }

    private boolean isReservationTimeBeforeOpen(OpenFieldTime openFieldTime, LocalDateTime startTime) {
        return openFieldTime.getOpenTime().isAfter(startTime.toLocalTime());
    }
}
