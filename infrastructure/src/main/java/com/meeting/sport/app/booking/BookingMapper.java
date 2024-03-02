package com.meeting.sport.app.booking;

class BookingMapper {

    static BookingEntity mapToEntity(Booking booking) {
        return BookingEntity.builder()
                .startTime(booking.getBookingTime().getStartTime())
                .endTime(booking.getBookingTime().getEndTime())
                .gameTime(booking.getBookingGameTime().gameTime())
                .build();
    }
}
