package com.meeting.sport.app.dto;

import com.meeting.sport.app.user.UserDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
@Builder
public record EventRoleDTO(
        Long id,
        String gameRole,
        boolean isAvailable,
        SportEventDTO sportEventDTO,
        UserDTO userDTO
){
}
