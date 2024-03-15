package com.meeting.sport.app.event.handler;

import com.meeting.sport.app.event.command.CreateSportEventCommand;
import com.meeting.sport.app.event.sport_event.SportEventService;
import com.meeting.sport.app.sport_event.SportEvent;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
class CreateSportEventHandler implements CommandHandler<CreateSportEventCommand> {

    private final SportEventService sportEventService;

    @Override
    public void handle(CreateSportEventCommand command) {
        SportEvent sportEvent = SportEvent.create(
                command.title(),
                command.description(),
                command.players(),
                command.minAge(),
                command.startTime(),
                command.gameTime());

        sportEventService.saveEvent(sportEvent);
    }
}
