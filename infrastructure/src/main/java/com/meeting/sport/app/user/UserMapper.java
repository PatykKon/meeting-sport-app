package com.meeting.sport.app.user;

import com.meeting.sport.app.user.dto.TokenDTO;
import com.meeting.sport.app.user.dto.UserDTO;
import com.meeting.sport.app.user.dto.UserResponse;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class UserMapper {


    static UserDTO entityToDTO(UserEntity userEntity) {

        userEntity.getAuthorities();

        UserDTO.UserDTOBuilder userDTO = UserDTO.builder();

        userDTO.tokenDTOS(tokenEntityListToTokenDTOList(userEntity.getTokenEntities()));
        SimpleGrantedAuthority auth = userEntityRoleAuth(userEntity);
        userDTO.authorities(mapToAuthorities(auth));
        userDTO.id(userEntity.getId());
        userDTO.firstname(userEntity.getFirstname());
        userDTO.lastname(userEntity.getLastname());
        userDTO.email(userEntity.getEmail());
        userDTO.password(userEntity.getPassword());
        userDTO.age(userEntity.getAge());
        userDTO.role(userEntity.getRole());

        return userDTO.build();
    }

    static UserDTO modelToDTO(User user) {

        UserDTO.UserDTOBuilder userDTO = UserDTO.builder();
        userDTO.id(user.getId());
        userDTO.email(user.getEmail());
        userDTO.age(user.getAge());
        userDTO.password(user.getPassword());
        userDTO.role(Role.valueOf(user.getRole()));

        return userDTO.build();
    }

    static List<SimpleGrantedAuthority> mapToAuthorities(SimpleGrantedAuthority authority) {
        return Collections.singletonList(authority);
    }

    static User entityToModel(UserEntity userEntity) {

        List<Token> tokens = tokenEntityListToTokenList(userEntity.getTokenEntities());
        Long id = userEntity.getId();
        String firstname = userEntity.getFirstname();
        String lastname = userEntity.getLastname();
        String email = userEntity.getEmail();
        String password = userEntity.getPassword();
        int age = userEntity.getAge();
        String role = userEntity.getRole().toString();

        return new User(id, firstname, lastname, email, password, age, role, tokens);
    }

    static User DTOToModel(UserDTO dto) {

        List<Token> tokens = tokenDTOListToTokenList(dto.tokenDTOS());
        Long id = dto.id();
        String firstname = dto.firstname();
        String lastname = dto.lastname();
        String email = dto.email();
        String password = dto.password();
        int age = dto.age();
        String role = dto.role().toString();

        return new User(id, firstname, lastname, email, password, age, role, tokens);
    }


    static UserEntity modelToEntity(User user) {

        UserEntity.UserEntityBuilder userEntity = UserEntity.builder();

        userEntity.tokenEntities(tokenListToTokenEntityList(user.getTokens()));
        userEntity.id(user.getId());
        userEntity.firstname(user.getFirstname());
        userEntity.lastname(user.getLastname());
        userEntity.email(user.getEmail());
        userEntity.password(user.getPassword());
        userEntity.age(user.getAge());
        userEntity.role(Role.valueOf(user.getRole()));

        return userEntity.build();
    }

    static UserResponse modelToResponse(User user) {

        Long id = user.getId();
        String firstname = user.getFirstname();
        String lastname = user.getLastname();
        int age = user.getAge();

        return new UserResponse(id, firstname, lastname, age);

    }

    protected static TokenDTO tokenEntityToTokenDTO(TokenEntity tokenEntity) {

        Long id = tokenEntity.getId();
        String token = tokenEntity.getToken();
        boolean revoked = tokenEntity.isRevoked();
        boolean expired = tokenEntity.isExpired();

        UserDTO userDTO = null;

        return new TokenDTO(id, token, revoked, expired, userDTO);

    }

    protected static List<TokenDTO> tokenEntityListToTokenDTOList(List<TokenEntity> list) {

        return list.stream()
                .map(UserMapper::tokenEntityToTokenDTO)
                .toList();
    }

    private static SimpleGrantedAuthority userEntityRoleAuth(UserEntity userEntity) {

        Role role = userEntity.getRole();

        return role.getAuth();

    }

    protected static Token tokenEntityToToken(TokenEntity tokenEntity) {

        Long id = tokenEntity.getId();
        String token = tokenEntity.getToken();
        boolean revoked = tokenEntity.isRevoked();
        boolean expired = tokenEntity.isExpired();

        return new Token(id, token, revoked, expired, null);

    }


    protected static Token tokenDTOToToken(TokenDTO tokenDTO) {

        Long id = tokenDTO.id();
        String token = tokenDTO.token();
        boolean revoked = tokenDTO.revoked();
        boolean expired = tokenDTO.expired();

        User user = null;

        return new Token(id, token, revoked, expired, user);
    }

    protected static List<Token> tokenDTOListToTokenList(List<TokenDTO> list) {

        return list.stream()
                .map(UserMapper::tokenDTOToToken)
                .toList();
    }

    protected static List<Token> tokenEntityListToTokenList(List<TokenEntity> list) {

        return list.stream()
                .map(UserMapper::tokenEntityToToken)
                .toList();
    }

    protected static TokenEntity tokenToTokenEntity(Token token) {

        TokenEntity.TokenEntityBuilder tokenEntity = TokenEntity.builder();

        tokenEntity.id(token.getId());
        tokenEntity.token(token.getToken());
        tokenEntity.revoked(token.isRevoked());
        tokenEntity.expired(token.isExpired());

        return tokenEntity.build();
    }

    protected static List<TokenEntity> tokenListToTokenEntityList(List<Token> list) {

       return list.stream()
               .map(UserMapper::tokenToTokenEntity)
               .toList();
    }
}

