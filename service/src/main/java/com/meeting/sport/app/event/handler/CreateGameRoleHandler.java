package com.meeting.sport.app.event.handler;

import com.meeting.sport.app.event.command.CreateGameRoleCommand;
import com.meeting.sport.app.event.sport_event.SportEventService;
import com.meeting.sport.app.sport_event.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
class CreateGameRoleHandler implements CommandHandler<CreateGameRoleCommand> {

    private final SportEventService sportEventService;

    @Override
    public void handle(CreateGameRoleCommand command) {

        SportEvent sportEvent = sportEventService.getEventById(command.sportEventId());

        List<EventRole> eventRoles = EventRole.crateAvailableRoleForUsers(command.playerTypes(),sportEvent);

        eventRoles.forEach(sportEvent::addGameRoles);

        sportEventService.saveEvent(sportEvent);
    }
}
