package com.meeting.sport.app.dto;

import com.meeting.sport.app.user.UserDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.ArrayList;
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
