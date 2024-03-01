package com.meeting.sport.app;

import org.springframework.stereotype.Repository;

@Repository
class BookingRepositoryImpl implements BookingRepository {

    private final BookingRepositoryJPA bookingRepositoryJPA;

    BookingRepositoryImpl(BookingRepositoryJPA bookingRepositoryJPA) {
        this.bookingRepositoryJPA = bookingRepositoryJPA;
    }

    public void save(Booking booking){
        bookingRepositoryJPA.save(BookingMapper.mapToEntity(booking));
    }

}
