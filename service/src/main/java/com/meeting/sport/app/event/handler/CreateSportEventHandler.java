package com.meeting.sport.app.event.handler;

import com.meeting.sport.app.event.command.CreateSportEventCommand;
import com.meeting.sport.app.event.CommandHandler;
import com.meeting.sport.app.sport_event.SportEvent;
import com.meeting.sport.app.sport_event.SportEventRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
class CreateSportEventHandler implements CommandHandler<CreateSportEventCommand> {

    private final SportEventRepository sportEventRepository;

    @Autowired
    CreateSportEventHandler(SportEventRepository sportEventRepository) {
        this.sportEventRepository = sportEventRepository;
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

        sportEventRepository.save(sportEvent);
    }
}
