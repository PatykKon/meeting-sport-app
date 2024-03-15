package com.meeting.sport.app.user;

import com.meeting.sport.app.sport_event.SportEventMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {SportEventMapper.class})
public interface UserMapper {

    @Mapping(source = "eventRoleEntities", target = "eventRoleDTOS")
    UserDTO entityToDTO(UserEntity userEntity);

    @Mapping(source = "eventRoleDTOS", target = "eventRoles")
    User DTOToModel(UserDTO dto);

    @Mapping(source = "eventRoles", target = "eventRoleEntities")
    UserEntity modelToEntity(User user);

    UserResponse entityToResponse(UserEntity userEntity);

}
