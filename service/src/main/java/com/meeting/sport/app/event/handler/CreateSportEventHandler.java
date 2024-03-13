package com.meeting.sport.app.event.handler;

import com.meeting.sport.app.event.command.CreateSportEventCommand;
import com.meeting.sport.app.event.CommandHandler;
import com.meeting.sport.app.sport_event.SportEvent;
import com.meeting.sport.app.sport_event.SportEventMapper;
import com.meeting.sport.app.sport_event.SportEventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
class CreateSportEventHandler implements CommandHandler<CreateSportEventCommand> {

    private final SportEventRepository sportEventRepository;
    private final SportEventMapper sportEventMapper;

    @Autowired
    CreateSportEventHandler(SportEventRepository sportEventRepository, SportEventMapper sportEventMapper) {
        this.sportEventRepository = sportEventRepository;
        this.sportEventMapper = sportEventMapper;
    }

    @Override
    public void handle(CreateSportEventCommand command) {
        SportEvent sportEvent = SportEvent.create(
                command.title(),
                command.description(),
                command.players(),
                command.minAge(),
                command.startTime(),
                command.gameTime());

        sportEventRepository.save(sportEventMapper.modelToDTO(sportEvent));
    }
}
