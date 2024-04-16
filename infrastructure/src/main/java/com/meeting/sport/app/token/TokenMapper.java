package com.meeting.sport.app.token;

import com.meeting.sport.app.user.Token;
import com.meeting.sport.app.user.UserMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
@Mapper(componentModel = "spring",uses = {UserMapper.class})
public interface TokenMapper {

    @Mapping(source = "userEntity", target = "userDTO")
    TokenDTO entityToDTO(TokenEntity entity);

    @Mapping(source = "userDTO", target = "user")
    Token DTOToModel(TokenDTO dto);

    @Mapping(source = "user", target = "userEntity")
    TokenEntity modelToEntity(Token token);
}
