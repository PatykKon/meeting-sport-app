package com.meeting.sport.app.booking;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Table(name = "BOOKING")
@Entity
@NoArgsConstructor
@Builder
@AllArgsConstructor
class BookingEntity {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    Long id;
    Integer gameTime;
    LocalDateTime startTime;
    LocalDateTime endTime;

}
