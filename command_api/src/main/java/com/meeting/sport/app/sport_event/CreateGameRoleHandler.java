package com.meeting.sport.app.sport_event;

import com.meeting.sport.app.CommandHandler;
import com.meeting.sport.app.sport_event.command.CreateGameRoleCommand;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
class CreateGameRoleHandler implements CommandHandler<CreateGameRoleCommand> {

    private final SportEventService sportEventService;

    @Override
    public Long handle(CreateGameRoleCommand command) {

        return sportEventService.createGameRoles(command.sportEventId(), command.eventRoleDataList());
    }
}
