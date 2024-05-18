package com.meeting.sport.app.sport_event;

import com.meeting.sport.app.CommandHandler;
import com.meeting.sport.app.sport_event.command.AssignEventToPlaceCommand;
import com.meeting.sport.app.sport_field.SportFieldFacade;
import com.meeting.sport.app.sport_field.dto.SportFieldDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
class AssignEventToPlaceHandler implements CommandHandler<AssignEventToPlaceCommand> {

    private final SportEventService sportEventService;
    private final SportFieldFacade sportFieldFacade;

    @Override
    public Long handle(AssignEventToPlaceCommand command) {

        SportFieldDTO sportField = sportFieldFacade.getSportFieldById(command.sportFieldId());

        return sportEventService.assignFieldToSportEvent(command.sportEventId(), sportField.id());
    }
}
