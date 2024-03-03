package com.meeting.sport.app.booking;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("api/booking")
class BookingController {

    private final BookingService bookingService;

    @PostMapping
    void makeBooking(@RequestBody BookingRequest request) {
        bookingService.makeBooking(request);
    }

}
