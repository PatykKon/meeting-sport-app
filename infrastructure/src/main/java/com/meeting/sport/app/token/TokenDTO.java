package com.meeting.sport.app.token;

import com.meeting.sport.app.user.UserDTO;

public record TokenDTO(
        Long id,
        String token,
        boolean revoked,
        boolean expired,
        UserDTO userDTO
){

}
