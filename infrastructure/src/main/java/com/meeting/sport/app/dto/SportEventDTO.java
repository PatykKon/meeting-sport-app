package com.meeting.sport.app.dto;

import lombok.Builder;

import java.time.LocalDateTime;
import java.util.List;

@Builder
public record SportEventDTO (
        Long id,
        String title,
        String description,
        int players,
        int minAge,
        LocalDateTime startTime,
        LocalDateTime endTime,
        Integer gameTime,
        SportFieldDTO sportFieldDTO,
        List<EventRoleDTO> eventRoleDTOS
){
}
