package com.meeting.sport.app.event.handler;

import com.meeting.sport.app.event.command.AssignEventToPlaceCommand;
import com.meeting.sport.app.event.sport_event.SportEventService;
import com.meeting.sport.app.sport_event.SportEvent;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
class AssignEventToPlaceHandler implements CommandHandler<AssignEventToPlaceCommand> {

    private final SportEventService sportEventService;

    @Override
    public Long handle(AssignEventToPlaceCommand command) {

        SportEvent sportEvent = sportEventService.getEventById(command.sportEventId());

        sportEvent.submitSportField(command.sportFieldId());
        return sportEventService.saveEvent(sportEvent);
    }
}
