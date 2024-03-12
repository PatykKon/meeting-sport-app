package com.meeting.sport.app.user;

import com.meeting.sport.app.dto.EventRoleDTO;
import com.meeting.sport.app.dto.SportEventDTO;

import java.util.List;

public record UserDTO(
        Long id,
        int age,
        List<SportEventDTO> sportEventDTOS,
        List<EventRoleDTO> eventRoleDTOS
){
}
