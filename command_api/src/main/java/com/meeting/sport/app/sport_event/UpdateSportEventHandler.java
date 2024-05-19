package com.meeting.sport.app.sport_event;

import com.meeting.sport.app.CommandHandler;
import com.meeting.sport.app.sport_event.command.UpdateEventCommand;
import com.meeting.sport.app.user.UserFacade;
import com.meeting.sport.app.user.dto.UserDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@AllArgsConstructor
class UpdateSportEventHandler implements CommandHandler<UpdateEventCommand> {

    private final SportEventService sportEventService;
    private final UserFacade userFacade;

    @Override
    @Transactional
    public Long handle(UpdateEventCommand command) {

        UserDTO loggedUser = userFacade.getLoggedUser(command.userEmail());

        return sportEventService.updateEvent(
                command.eventId(),
                command.title(),
                command.description(),
                command.players(),
                command.minAge(),
                command.startTime(),
                command.gameTime(),
                loggedUser.id(),
                command.minPlayers());
    }
}
