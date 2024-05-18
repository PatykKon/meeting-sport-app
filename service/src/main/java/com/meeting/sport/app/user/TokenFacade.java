package com.meeting.sport.app.user;

import com.meeting.sport.app.user.dto.UserDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class TokenFacade {

    private final TokenService tokenService;
    public void createToken(UserDTO userDTO,String jwtToken){
        tokenService.createToken(userDTO,jwtToken);
    }

    public void revokeAllUserTokens(Long id){
        tokenService.revokeAllUserTokens(id);
    }

    public boolean isTokenValid(String token){
        return tokenService.isTokenValid(token);
    }

    public void checkToken(String jwt){
        tokenService.checkToken(jwt);
    }
}
