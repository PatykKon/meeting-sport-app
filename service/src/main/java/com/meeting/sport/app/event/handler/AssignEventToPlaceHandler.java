package com.meeting.sport.app.event.handler;

import com.meeting.sport.app.event.command.AssignEventToPlaceCommand;
import com.meeting.sport.app.event.CommandHandler;
import com.meeting.sport.app.sport_event.SportEvent;
import com.meeting.sport.app.sport_event.SportEventRepository;
import com.meeting.sport.app.sport_field.SportField;
import com.meeting.sport.app.sport_field.SportFieldRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
class AssignEventToPlaceHandler implements CommandHandler<AssignEventToPlaceCommand> {

    private final SportEventRepository sportEventRepository;
    private final SportFieldRepository sportFieldRepository;

    @Autowired
    AssignEventToPlaceHandler(SportEventRepository sportEventRepository, SportFieldRepository sportFieldRepository) {
        this.sportEventRepository = sportEventRepository;
        this.sportFieldRepository = sportFieldRepository;
    }

    @Override
    public void handle(AssignEventToPlaceCommand command) {
        SportEvent sportEvent = sportEventRepository.findById(command.sportEventId());
        SportField sportField = sportFieldRepository.findById(command.sportFieldId());
        sportField.addEventToSportField(sportEvent);
        sportFieldRepository.save(sportField);
    }
}
