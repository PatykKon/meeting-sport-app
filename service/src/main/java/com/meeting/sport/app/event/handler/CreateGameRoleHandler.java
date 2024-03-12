package com.meeting.sport.app.event.handler;

import com.meeting.sport.app.dto.SportEventDTO;
import com.meeting.sport.app.event.command.CreateGameRoleCommand;
import com.meeting.sport.app.event.CommandHandler;
import com.meeting.sport.app.sport_event.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
class CreateGameRoleHandler implements CommandHandler<CreateGameRoleCommand> {

    private final SportEventRepository sportEventRepository;
    private final SportEventMapper sportEventMapper;

    @Autowired
    CreateGameRoleHandler(SportEventRepository sportEventRepository, SportEventMapper sportEventMapper) {
        this.sportEventRepository = sportEventRepository;
        this.sportEventMapper = sportEventMapper;
    }

    @Override
    public void handle(CreateGameRoleCommand command) {

        SportEventDTO sportEventDTO= sportEventRepository.findById(command.sportEventId());
        SportEvent sportEvent = sportEventMapper.DTOToModel(sportEventDTO);

        List<EventRole> eventRoles = EventRole.crateGameUsers(command.playerTypes(),sportEvent);

        eventRoles.forEach(sportEvent::addGameUser);

        sportEventRepository.save(sportEventMapper.modelToDTO(sportEvent));
    }
}
