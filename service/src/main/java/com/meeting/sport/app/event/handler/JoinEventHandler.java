package com.meeting.sport.app.event.handler;

import com.meeting.sport.app.dto.EventRoleDTO;
import com.meeting.sport.app.user.UserDTO;
import com.meeting.sport.app.sport_event.*;
import com.meeting.sport.app.event.command.JoinEventCommand;
import com.meeting.sport.app.event.CommandHandler;
import com.meeting.sport.app.user.UserMapper;
import com.meeting.sport.app.user.UserRepository;
import com.meeting.sport.app.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
class JoinEventHandler implements CommandHandler<JoinEventCommand> {

    private final EventRoleRepository eventRoleRepository;
    private final EventRoleMapper eventRoleMapper;
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Autowired
    JoinEventHandler(EventRoleRepository eventRoleRepository, EventRoleMapper eventRoleMapper, UserRepository userRepository, UserMapper userMapper) {
        this.eventRoleRepository = eventRoleRepository;
        this.eventRoleMapper = eventRoleMapper;
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    @Transactional
    public void handle(JoinEventCommand command) {

        EventRoleDTO eventRoleDTO = eventRoleRepository.findAvailableRole(command.eventId(),command.gameRole());
        EventRole eventRole = eventRoleMapper.DTOToModel(eventRoleDTO);
        SportEvent sportEvent = eventRole.getSportEvent();

        UserDTO userTest = userRepository.findById(56);
        User user = userMapper.DTOToModel(userTest);

        boolean isUserExistInEvent = eventRoleRepository.isUserExistInEvent(command.eventId(), user.getId());

        if(isUserExistInEvent){
            throw new RuntimeException("Użytkownik o id:" + user.getId()+ " bierzę juz w wydarzeniu!");
        }
        sportEvent.checkRequirements(user);

        eventRole.assignUser(user);
        eventRoleRepository.save(eventRoleMapper.modelToDTO(eventRole));
    }
}
