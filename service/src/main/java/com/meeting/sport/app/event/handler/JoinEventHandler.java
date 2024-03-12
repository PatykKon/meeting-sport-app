package com.meeting.sport.app.event.handler;

import com.meeting.sport.app.user.UserDTO;
import com.meeting.sport.app.dto.SportEventDTO;
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

    private final SportEventRepository sportEventRepository;
    private final SportEventMapper sportEventMapper;

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Autowired
    JoinEventHandler(SportEventRepository sportEventRepository, SportEventMapper sportEventMapper, UserRepository userRepository, UserMapper userMapper) {
        this.sportEventRepository = sportEventRepository;
        this.sportEventMapper = sportEventMapper;
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    @Transactional
    public void handle(JoinEventCommand command) {
        SportEventDTO sportEventDTO = sportEventRepository.findById(command.eventId());
        SportEvent sportEvent = sportEventMapper.DTOToModel(sportEventDTO);

        UserDTO userTest = userRepository.findById(56);
        User user = userMapper.DTOToModel(userTest);

        sportEvent.joinToEvent(user,command.gameRole());
        sportEventRepository.save(sportEventMapper.modelToDTO(sportEvent));



    }
}
