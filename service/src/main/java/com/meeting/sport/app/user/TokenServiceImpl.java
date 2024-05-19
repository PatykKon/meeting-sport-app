package com.meeting.sport.app.user;

import com.meeting.sport.app.user.dto.TokenDTO;
import com.meeting.sport.app.user.dto.UserDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
class TokenServiceImpl implements TokenService {

    private final TokenRepository tokenRepository;
    @Override
    public void createToken(UserDTO userDTO, String jtwToken){

        User user = UserMapper.DTOToModel(userDTO);

        Token token = Token.createToken(user,jtwToken);

        TokenEntity tokenEntity = TokenMapper.modelToEntity(token);

        tokenRepository.save(tokenEntity);
    }
    @Override
    public void revokeAllUserTokens(Long id){
        List<TokenEntity> tokenEntityList = tokenRepository.findAllValidTokenByUser(id);
        List<TokenDTO> tokenDTOS = tokenEntityList.stream().map(TokenMapper::entityToDTO).toList();
        List<Token> tokens = tokenDTOS.stream().map(TokenMapper::DTOToModel).toList();


        if (tokens.isEmpty())
            return;
        tokens.forEach(token -> {
            token.changeExpired();
            token.changeRevoked();
        });
       tokenRepository.saveAll(tokens.stream().map(TokenMapper::modelToEntity).toList());
    }

    @Override
    public boolean isTokenValid(String jwt) {
        return tokenRepository.findByToken(jwt)
                .map(t -> !t.isExpired() && !t.isRevoked())
                .orElse(false);
    }

    public void checkToken(String jwt) {
        TokenEntity tokenEntity = tokenRepository.findByToken(jwt).orElse(null);
        Token storedToken = TokenMapper.entityToModel(tokenEntity);
        if (storedToken != null) {
            storedToken.changeExpired();
            storedToken.changeRevoked();
            tokenRepository.save(TokenMapper.modelToEntity(storedToken));
        }
    }
}
