package com.meeting.sport.app.user;

import com.meeting.sport.app.user.dto.TokenDTO;
import com.meeting.sport.app.user.dto.UserDTO;

class TokenMapper {

    static TokenDTO entityToDTO(TokenEntity entity) {

        UserDTO userDTO = UserMapper.entityToDTO(entity.getUserEntity());
        Long id = entity.getId();
        String token = entity.getToken();
        boolean revoked = entity.isRevoked();
        boolean expired = entity.isExpired();

        return new TokenDTO(id, token, revoked, expired, userDTO);

    }

    static Token entityToModel(TokenEntity entity) {

        User user = UserMapper.entityToModel(entity.getUserEntity());
        Long id = entity.getId();
        String token = entity.getToken();
        boolean revoked = entity.isRevoked();
        boolean expired = entity.isExpired();

        return new Token(id, token, revoked, expired, user);
    }

    static Token DTOToModel(TokenDTO dto) {

        User user = UserMapper.DTOToModel(dto.userDTO());
        Long id = dto.id();
        String token = dto.token();
        boolean revoked = dto.revoked();
        boolean expired = dto.expired();

        return new Token(id, token, revoked, expired, user);

    }


    static TokenEntity modelToEntity(Token token) {

        TokenEntity.TokenEntityBuilder tokenEntity = TokenEntity.builder();

        tokenEntity.userEntity(UserMapper.modelToEntity(token.getUser()));
        tokenEntity.id(token.getId());
        tokenEntity.token(token.getToken());
        tokenEntity.revoked(token.isRevoked());
        tokenEntity.expired(token.isExpired());

        return tokenEntity.build();
    }
}
