package com.meeting.sport.app.dto;

import java.util.List;

public record GamerDTO(
        Long id,
        int age,
        List<SportEventDTO> sportEventDTOS
){
}
