package com.meeting.sport.app.booking;

import org.springframework.data.jpa.repository.JpaRepository;

interface BookingRepositoryJPA extends JpaRepository<BookingEntity, Long> {
}
