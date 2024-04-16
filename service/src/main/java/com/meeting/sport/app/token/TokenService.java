package com.meeting.sport.app.token;

import com.meeting.sport.app.user.dto.UserDTO;

interface TokenService {

    void createToken(UserDTO userDTO, String jtwToken);

    void revokeAllUserTokens(Long id);

    boolean isTokenValid(String token);
}
