package com.meeting.sport.app.event.handler;

import com.meeting.sport.app.event.sport_event.SportEventService;
import com.meeting.sport.app.event.user.UserService;
import com.meeting.sport.app.sport_event.*;
import com.meeting.sport.app.event.command.JoinEventCommand;
import com.meeting.sport.app.user.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@AllArgsConstructor
class JoinEventHandler implements CommandHandler<JoinEventCommand> {

    private final UserService userService;
    private final SportEventService sportEventService;

    @Override
    @Transactional
    public void handle(JoinEventCommand command) {

        EventRole eventRole = sportEventService.getAvailableEventRoleById(command.eventId(), command.gameRole());
        SportEvent sportEvent = eventRole.getSportEvent();

        User loggedUser = userService.getLoggedUser(command.userEmail());

        boolean isUserExistInEvent = sportEventService.isUserExistInEvent(command.eventId(), loggedUser.getId());

        if (isUserExistInEvent) {
            throw new RuntimeException("Użytkownik o id:" + loggedUser.getId() + " bierzę juz udział w wydarzeniu!");
        }
        sportEvent.checkRequirements(loggedUser);

        eventRole.assignUser(loggedUser);
        sportEventService.saveEventRole(eventRole);
    }
}
