package com.meeting.sport.app.user;


import com.meeting.sport.app.sport_event.SportEventMapper;
import com.meeting.sport.app.user.dto.UserDTO;
import com.meeting.sport.app.user.dto.UserResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring", uses = {SportEventMapper.class, AuthorityMapper.class})
public interface UserMapper {


    @Mapping(source = "tokenEntities", target = "tokenDTOS")
    @Mapping(source = "role.auth", target = "authorities", qualifiedByName = "mapToAuthorities")
    UserDTO entityToDTO(UserEntity userEntity);



    @Mapping(source = "tokenDTOS", target = "tokens")
    User DTOToModel(UserDTO dto);

    @Mapping(source = "tokens", target = "tokenEntities")
    UserEntity modelToEntity(User user);

    UserResponse entityToResponse(UserEntity userEntity);

    UserResponse modelToResponse(UserDTO dto);

}
