package com.meeting.sport.app.sport_event;

import com.meeting.sport.app.CommandHandler;
import com.meeting.sport.app.sport_event.command.CreateSportEventCommand;
import com.meeting.sport.app.user.User;
import com.meeting.sport.app.user.UserFacade;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@AllArgsConstructor
class CreateSportEventHandler implements CommandHandler<CreateSportEventCommand> {

    private final UserFacade userFacade;
    private final SportEventService sportEventService;


    @Transactional
    public Long handle(CreateSportEventCommand command) {

        User user = userFacade.getLoggedUser(command.userEmail());

        return sportEventService.createSportEvent(
                command.title(),
                command.description(),
                command.players(),
                command.minAge(),
                command.startTime(),
                command.gameTime(),
                user.getId(),
                command.minPlayers()
        );
    }
}
