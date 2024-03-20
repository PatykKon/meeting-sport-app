package com.meeting.sport.app.user;

import com.meeting.sport.app.sport_event.SportEventMapper;
import com.meeting.sport.app.token.TokenMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {SportEventMapper.class})
public interface UserMapper {

    @Mapping(source = "eventRoleEntities", target = "eventRoleDTOS")
    @Mapping(source = "tokenEntities", target = "tokenDTOS")
    UserDTO entityToDTO(UserEntity userEntity);

    @Mapping(source = "eventRoleDTOS", target = "eventRoles")
    @Mapping(source = "tokenDTOS", target = "tokens")
    User DTOToModel(UserDTO dto);

    @Mapping(source = "eventRoles", target = "eventRoleEntities")
    @Mapping(source = "tokens", target = "tokenEntities")
    UserEntity modelToEntity(User user);

    UserResponse entityToResponse(UserEntity userEntity);

}
