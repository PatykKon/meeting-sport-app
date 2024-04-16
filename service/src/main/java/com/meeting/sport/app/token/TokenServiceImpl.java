package com.meeting.sport.app.token;

import com.meeting.sport.app.user.*;
import com.meeting.sport.app.user.dto.UserDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
class TokenServiceImpl implements TokenService {

    private final UserMapper userMapper;
    private final TokenRepository tokenRepository;
    private final TokenMapper tokenMapper;
    @Override
    public void createToken(UserDTO userDTO, String jtwToken){

        User user = userMapper.DTOToModel(userDTO);

        Token token = Token.createToken(user,jtwToken);

        TokenEntity tokenEntity = tokenMapper.modelToEntity(token);

        tokenRepository.save(tokenEntity);
    }
    @Override
    public void revokeAllUserTokens(Long id){
        List<TokenEntity> tokenEntityList = tokenRepository.findAllValidTokenByUser(id);
        List<TokenDTO> tokenDTOS = tokenEntityList.stream().map(tokenMapper::entityToDTO).toList();
        List<Token> tokens = tokenDTOS.stream().map(tokenMapper::DTOToModel).toList();


        if (tokens.isEmpty())
            return;
        tokens.forEach(token -> {
            token.changeExpired();
            token.changeRevoked();
        });
       tokenRepository.saveAll(tokens.stream().map(tokenMapper::modelToEntity).toList());
    }

    @Override
    public boolean isTokenValid(String jwt) {
        return tokenRepository.findByToken(jwt)
                .map(t -> !t.isExpired() && !t.isRevoked())
                .orElse(false);
    }
}
