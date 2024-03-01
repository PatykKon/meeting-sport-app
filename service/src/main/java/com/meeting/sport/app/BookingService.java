package com.meeting.sport.app;


import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
@AllArgsConstructor
public class BookingService {

    private final BookingRepository bookingRepository;

    public void makeBooking(BookingRequest bookingRequest) {

        Booking booking = Booking.createBooking(
                bookingRequest.startDateGame(),
                bookingRequest.gameTime());

       bookingRepository.save(booking);
    }
}
