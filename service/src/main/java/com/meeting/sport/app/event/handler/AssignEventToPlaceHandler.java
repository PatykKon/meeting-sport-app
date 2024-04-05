package com.meeting.sport.app.event.handler;

import com.meeting.sport.app.event.command.AssignEventToPlaceCommand;
import com.meeting.sport.app.event.sport_event.SportEventService;
import com.meeting.sport.app.event.sport_field.SportFieldService;
import com.meeting.sport.app.sport_event.SportEvent;
import com.meeting.sport.app.sport_field.SportField;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
class AssignEventToPlaceHandler implements CommandHandler<AssignEventToPlaceCommand> {

    private final SportEventService sportEventService;
    private final SportFieldService sportFieldService;

    @Override
    public Long handle(AssignEventToPlaceCommand command) {

        SportField sportField = sportFieldService.getSportFieldById(command.sportFieldId());

        SportEvent sportEvent = sportEventService.getEventById(command.sportEventId());
        sportEvent.assignSportField(sportField);

        return sportEventService.saveEvent(sportEvent);
    }
}
