package com.meeting.sport.app.event.handler;

import com.meeting.sport.app.event.command.CreateSportEventCommand;
import com.meeting.sport.app.event.sport_event.SportEventService;
import com.meeting.sport.app.event.user.UserService;
import com.meeting.sport.app.sport_event.SportEvent;
import com.meeting.sport.app.user.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@AllArgsConstructor
class CreateSportEventHandler implements CommandHandler<CreateSportEventCommand> {

    private final UserService userService;
    private final SportEventService sportEventService;




    @Transactional
    public Long handle(CreateSportEventCommand command) {

        User user = userService.getLoggedUser(command.userEmail());

        SportEvent sportEvent = SportEvent.create(
                command.title(),
                command.description(),
                command.players(),
                command.minAge(),
                command.startTime(),
                command.gameTime(),
                user.getId());

       return sportEventService.saveEvent(sportEvent);

    }

}
