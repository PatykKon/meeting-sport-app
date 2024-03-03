package com.meeting.sport.app.booking;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;


@Component
@AllArgsConstructor
class BookingService {

    private final BookingRepository bookingRepository;

    void makeBooking(BookingRequest bookingRequest) {

        Booking booking = Booking.createBooking(
                bookingRequest.startDateGame(),
                bookingRequest.gameTime(),
                bookingRequest.sportField());

        bookingRepository.save(booking);
    }
}
