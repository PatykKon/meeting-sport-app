package com.meeting.sport.app.event.handler;

import com.meeting.sport.app.dto.SportEventDTO;
import com.meeting.sport.app.sport_event.*;
import com.meeting.sport.app.event.command.JoinEventCommand;
import com.meeting.sport.app.event.CommandHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
class JoinEventHandler implements CommandHandler<JoinEventCommand> {

    private final SportEventRepository sportEventRepository;
    private final SportEventMapper sportEventMapper;

    @Autowired
    JoinEventHandler(SportEventRepository sportEventRepository, SportEventMapper sportEventMapper) {
        this.sportEventRepository = sportEventRepository;
        this.sportEventMapper = sportEventMapper;
    }

    @Override
    public void handle(JoinEventCommand command) {
        SportEventDTO sportEventDTO = sportEventRepository.findById(command.eventId());
        Gamer gamer = new Gamer(20);
        SportEvent sportEvent = sportEventMapper.DTOToModel(sportEventDTO);

        sportEvent.joinToEvent(gamer,command.gameRole());
        sportEventRepository.save(sportEventMapper.modelToDTO(sportEvent));


    }
}
