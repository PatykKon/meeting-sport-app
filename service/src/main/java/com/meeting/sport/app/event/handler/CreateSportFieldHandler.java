package com.meeting.sport.app.event.handler;

import com.meeting.sport.app.event.command.AddSportFieldCommand;
import com.meeting.sport.app.event.sport_field.SportFieldService;
import com.meeting.sport.app.sport_field.SportField;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
class CreateSportFieldHandler implements CommandHandler<AddSportFieldCommand> {

    private final SportFieldService sportFieldService;

    @Override
    public void handle(AddSportFieldCommand command) {

        SportField sportField = SportField.createSportField(
                command.fieldType(),
                command.fieldSpace(),
                command.city(),
                command.street(),
                command.number());

        sportFieldService.save(sportField);
    }
}
