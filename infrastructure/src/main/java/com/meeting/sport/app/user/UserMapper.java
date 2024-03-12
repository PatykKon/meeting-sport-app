package com.meeting.sport.app.user;

import com.meeting.sport.app.sport_event.SportEventMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring",uses = {SportEventMapper.class})
public interface UserMapper {

    @Mapping(source = "sportEventDTOS", target = "sportEventEntities")
    @Mapping(source = "eventRoleDTOS", target = "eventRoleEntities")
    UserEntity DTOToEntity(UserDTO dto);

    @Mapping(source = "sportEventEntities", target = "sportEventDTOS")
    @Mapping(source = "eventRoleEntities", target = "eventRoleDTOS")
    UserDTO entityToDTO(UserEntity userEntity);

    @Mapping(source = "sportEventDTOS", target = "events")
    @Mapping(source = "eventRoleDTOS", target = "eventRoles")
    User DTOToModel(UserDTO dto);

    @Mapping(source = "events", target = "sportEventDTOS")
    @Mapping(source = "eventRoles", target = "eventRoleDTOS")
    UserDTO modelToDTO(User user);

    UserResponse entityToResponse(UserEntity userEntity);

}
