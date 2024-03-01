package com.meeting.sport.app;

import org.springframework.data.jpa.repository.JpaRepository;

interface BookingRepositoryJPA extends JpaRepository<BookingEntity, Long> {
}
