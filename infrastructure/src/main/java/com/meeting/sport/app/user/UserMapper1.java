package com.meeting.sport.app.user;

import com.meeting.sport.app.token.TokenDTO;
import com.meeting.sport.app.token.TokenEntity;
import com.meeting.sport.app.user.dto.UserDTO;
import com.meeting.sport.app.user.dto.UserResponse;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UserMapper1 {

    public static UserDTO entityToDTO(UserEntity userEntity) {
        if (userEntity == null) {
            return null;
        }


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

    public static List<SimpleGrantedAuthority> mapToAuthorities(SimpleGrantedAuthority authority) {
        return Collections.singletonList(authority);
    }

    public static User DTOToModel(UserDTO dto) {
        if (dto == null) {
            return null;
        }

        List<Token> tokens = tokenDTOListToTokenList(dto.tokenDTOS());
        Long id = dto.id();
        String firstname = dto.firstname();
        String lastname = dto.lastname();
        String email = dto.email();
        String password = dto.password();
        int age = dto.age();
        Role role = dto.role();

        User user = new User(id, firstname, lastname, email, password, age, role, tokens);

        return user;
    }


    public static UserEntity modelToEntity(User user) {
        if (user == null) {
            return null;
        }

        UserEntity.UserEntityBuilder userEntity = UserEntity.builder();

        userEntity.tokenEntities(tokenListToTokenEntityList(user.getTokens()));
        userEntity.id(user.getId());
        userEntity.firstname(user.getFirstname());
        userEntity.lastname(user.getLastname());
        userEntity.email(user.getEmail());
        userEntity.password(user.getPassword());
        userEntity.age(user.getAge());
        userEntity.role(user.getRole());

        return userEntity.build();
    }


    public static UserResponse entityToResponse(UserEntity userEntity) {
        if (userEntity == null) {
            return null;
        }

        Long   id = userEntity.getId();
        String firstname = userEntity.getFirstname();
        String lastname = userEntity.getLastname();
        int    age = userEntity.getAge();

        return new UserResponse(id, firstname, lastname, age);


    }

    public static UserResponse DTOToResponse(UserDTO dto) {
        if (dto == null) {
            return null;
        }

         Long   id = dto.id();
         String firstname = dto.firstname();
         String lastname = dto.lastname();
         int    age = dto.age();

        return new UserResponse(id, firstname, lastname, age);

    }

    public static UserResponse modelToResponse(User user) {
        if (user == null) {
            return null;
        }

        Long   id = user.getId();
        String firstname = user.getFirstname();
        String lastname = user.getLastname();
        int    age = user.getAge();

        return new UserResponse(id, firstname, lastname, age);

    }

    protected static TokenDTO tokenEntityToTokenDTO(TokenEntity tokenEntity) {
        if (tokenEntity == null) {
            return null;
        }

        Long id = null;
        String token = null;
        boolean revoked = false;
        boolean expired = false;

        id = tokenEntity.getId();
        token = tokenEntity.getToken();
        revoked = tokenEntity.isRevoked();
        expired = tokenEntity.isExpired();

        UserDTO userDTO = null;

        TokenDTO tokenDTO = new TokenDTO(id, token, revoked, expired, userDTO);

        return tokenDTO;
    }

    protected static List<TokenDTO> tokenEntityListToTokenDTOList(List<TokenEntity> list) {
        if (list == null) {
            return null;
        }

        List<TokenDTO> list1 = new ArrayList<TokenDTO>(list.size());
        for (TokenEntity tokenEntity : list) {
            list1.add(tokenEntityToTokenDTO(tokenEntity));
        }

        return list1;
    }

    private static SimpleGrantedAuthority userEntityRoleAuth(UserEntity userEntity) {
        if (userEntity == null) {
            return null;
        }
        Role role = userEntity.getRole();
        if (role == null) {
            return null;
        }
        SimpleGrantedAuthority auth = role.getAuth();
        if (auth == null) {
            return null;
        }
        return auth;
    }

    protected static Token tokenDTOToToken(TokenDTO tokenDTO) {
        if (tokenDTO == null) {
            return null;
        }

        Long id = null;
        String token = null;
        boolean revoked = false;
        boolean expired = false;

        id = tokenDTO.id();
        token = tokenDTO.token();
        revoked = tokenDTO.revoked();
        expired = tokenDTO.expired();

        User user = null;

        Token token1 = new Token(id, token, revoked, expired, user);

        return token1;
    }

    protected static List<Token> tokenDTOListToTokenList(List<TokenDTO> list) {
        if (list == null) {
            return null;
        }

        List<Token> list1 = new ArrayList<Token>(list.size());
        for (TokenDTO tokenDTO : list) {
            list1.add(tokenDTOToToken(tokenDTO));
        }

        return list1;
    }

    protected static TokenEntity tokenToTokenEntity(Token token) {
        if (token == null) {
            return null;
        }

        TokenEntity.TokenEntityBuilder tokenEntity = TokenEntity.builder();

        tokenEntity.id(token.getId());
        tokenEntity.token(token.getToken());
        tokenEntity.revoked(token.isRevoked());
        tokenEntity.expired(token.isExpired());

        return tokenEntity.build();
    }

    protected static List<TokenEntity> tokenListToTokenEntityList(List<Token> list) {
        if (list == null) {
            return null;
        }

        List<TokenEntity> list1 = new ArrayList<TokenEntity>(list.size());
        for (Token token : list) {
            list1.add(tokenToTokenEntity(token));
        }

        return list1;
    }
}

