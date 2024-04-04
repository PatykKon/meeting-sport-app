package com.meeting.sport.app.event.handler;

import com.meeting.sport.app.event.command.LeaveEventCommand;
import com.meeting.sport.app.event.sport_event.SportEventService;
import com.meeting.sport.app.event.user.UserService;
import com.meeting.sport.app.sport_event.EventRole;
import com.meeting.sport.app.user.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@AllArgsConstructor
class LeaveEventHandler implements CommandHandler<LeaveEventCommand> {

    private final SportEventService sportEventService;
    private final UserService userService;


    @Override
    @Transactional
    public Long handle(LeaveEventCommand command) {

        User loggedUser = userService.getLoggedUser(command.userEmail());

        EventRole eventRole =sportEventService.getUserEventRole(loggedUser.getId(), command.eventId());

        eventRole.leaveEvent();

        return sportEventService.saveEventRole(eventRole);
    }
}