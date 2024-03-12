package com.meeting.sport.app.dto;

import com.meeting.sport.app.user.UserDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;



@AllArgsConstructor
@Getter
public class EventRoleDTO {
    private Long id;
    private String gameRole;
    private boolean isAvailable;
    private SportEventDTO sportEventDTO;
    private UserDTO userDTO;
}
