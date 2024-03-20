package com.meeting.sport.app.token;

import com.meeting.sport.app.user.TokenType;
import com.meeting.sport.app.user.User;
import com.meeting.sport.app.user.UserDTO;
import org.apache.catalina.UserDatabase;

public record TokenDTO(
        Long id,
        String token,
        boolean revoked,
        boolean expired,

        UserDTO userDTO
){

}
