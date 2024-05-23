package com.meeting.sport.app.sport_event;

import com.meeting.sport.app.CommandHandler;
import com.meeting.sport.app.sport_event.command.LeaveEventCommand;
import com.meeting.sport.app.user.UserFacade;
import com.meeting.sport.app.user.dto.UserDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@AllArgsConstructor
class LeaveEventHandler implements CommandHandler<LeaveEventCommand> {

    private final SportEventService sportEventService;
    private final UserFacade userFacade;

    @Override
    @Transactional
    public Long handle(LeaveEventCommand command) {

        UserDTO loggedUser = userFacade.getLoggedUser(command.userEmail());

        return sportEventService.laveEvent(command.eventId(), loggedUser.id());
    }
}