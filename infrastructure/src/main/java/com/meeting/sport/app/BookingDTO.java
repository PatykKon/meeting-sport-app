package com.meeting.sport.app;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record  BookingDTO(

        LocalDateTime startGame,
        LocalDateTime endGame,
        Integer gameTime
) {


}
