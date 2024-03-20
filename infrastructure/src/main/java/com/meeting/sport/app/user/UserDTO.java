package com.meeting.sport.app.user;

import com.meeting.sport.app.dto.EventRoleDTO;
import com.meeting.sport.app.token.TokenDTO;

import java.util.List;

public record UserDTO(
        Long id,
        String firstname,
        String lastname,
        String email,
        String password,
        int age,
        List<EventRoleDTO> eventRoleDTOS,
        Role role,
        List<TokenDTO> tokenDTOS
) {
}
