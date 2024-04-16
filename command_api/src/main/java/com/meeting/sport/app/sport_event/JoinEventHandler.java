package com.meeting.sport.app.sport_event;

import com.meeting.sport.app.CommandHandler;
import com.meeting.sport.app.sport_event.command.JoinEventCommand;
import com.meeting.sport.app.user.UserFacade;
import com.meeting.sport.app.user.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@AllArgsConstructor
class JoinEventHandler implements CommandHandler<JoinEventCommand> {

    private final SportEventService sportEventService;
    private final UserFacade userFacade;

    @Override
    @Transactional
    public Long handle(JoinEventCommand command) {

        User loggedUser = userFacade.getLoggedUser(command.userEmail());

        return sportEventService.joinEvent(command.eventId(), command.gameRole(), loggedUser);
    }
}
