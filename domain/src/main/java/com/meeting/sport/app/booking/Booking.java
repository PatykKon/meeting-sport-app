package com.meeting.sport.app.booking;

import com.meeting.sport.app.sport_field.SportField;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class Booking {

    private final BookingTime bookingTime;
    private final BookingGameTime bookingGameTime;
    private final SportField sportField;

    private Booking(BookingTime bookingTime, BookingGameTime bookingGameTime, SportField sportField) {
        this.bookingTime = bookingTime;
        this.bookingGameTime = bookingGameTime;
        this.sportField = sportField;
    }

    public static Booking createBooking(LocalDateTime gameStartTime, Integer gameTime, SportField sportField) {
        BookingGameTime bookingGameTime = new BookingGameTime(gameTime);
        LocalDateTime endTime = gameStartTime.plusHours(gameTime);

        BookingTime bookingTime = new BookingTime(gameStartTime, endTime);

        return new Booking(bookingTime, bookingGameTime, sportField);
    }
}
