package com.meeting.sport.app;


class BookingMapper {

    static BookingEntity mapToEntity(Booking booking){
        return BookingEntity.builder()
                .startTime(booking.getBookingTime().startTime())
                .endTime(booking.getBookingTime().endTime())
                .gameTime(booking.getBookingGameTime().gameTime())
                .build();
    }
}
