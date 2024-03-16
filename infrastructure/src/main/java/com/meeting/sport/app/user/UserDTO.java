package com.meeting.sport.app.user;

import com.meeting.sport.app.dto.EventRoleDTO;

import java.util.List;

public record UserDTO(
        Long id,
        String name,
        int age,
        List<EventRoleDTO> eventRoleDTOS
) {
}
