package com.meeting.sport.app.token;

import com.meeting.sport.app.user.Token;
import com.meeting.sport.app.user.User;
import com.meeting.sport.app.user.UserMapper;
import com.meeting.sport.app.user.dto.UserDTO;

public class TokenMapper {

    public static TokenDTO entityToDTO(TokenEntity entity) {
        if (entity == null) {
            return null;
        }

        UserDTO userDTO = UserMapper.entityToDTO(entity.getUserEntity());
        Long id = entity.getId();
        String token = entity.getToken();
        boolean revoked = entity.isRevoked();
        boolean expired = entity.isExpired();

        return new TokenDTO(id, token, revoked, expired, userDTO);

    }

    public static Token DTOToModel(TokenDTO dto) {
        if (dto == null) {
            return null;
        }


        User user = UserMapper.DTOToModel(dto.userDTO());
        Long id = dto.id();
        String token = dto.token();
        boolean revoked = dto.revoked();
        boolean expired = dto.expired();

        return new Token(id, token, revoked, expired, user);

    }


    public static TokenEntity modelToEntity(Token token) {
        if (token == null) {
            return null;
        }

        TokenEntity.TokenEntityBuilder tokenEntity = TokenEntity.builder();

        tokenEntity.userEntity(UserMapper.modelToEntity(token.getUser()));
        tokenEntity.id(token.getId());
        tokenEntity.token(token.getToken());
        tokenEntity.revoked(token.isRevoked());
        tokenEntity.expired(token.isExpired());

        return tokenEntity.build();
    }
}
