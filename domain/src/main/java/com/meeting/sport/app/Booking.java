package com.meeting.sport.app;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class Booking {

    private final BookingTime bookingTime;
    private final BookingGameTime bookingGameTime;

    private Booking(BookingTime bookingTime, BookingGameTime bookingGameTime) {
        this.bookingTime = bookingTime;
        this.bookingGameTime = bookingGameTime;
    }

    public static Booking createBooking(LocalDateTime gameStartTime, Integer gameTime) {
        BookingGameTime bookingGameTime = new BookingGameTime(gameTime);
        LocalDateTime endTime = gameStartTime.plusHours(gameTime);
        BookingTime bookingTime = new BookingTime(gameStartTime, endTime);

        return new Booking(bookingTime, bookingGameTime);
    }
}
