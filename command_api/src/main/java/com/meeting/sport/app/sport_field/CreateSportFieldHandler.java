package com.meeting.sport.app.sport_field;


import com.meeting.sport.app.CommandHandler;
import com.meeting.sport.app.sport_field.command.AddSportFieldCommand;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
class CreateSportFieldHandler implements CommandHandler<AddSportFieldCommand> {

    private final SportFieldService sportFieldService;

    @Override
    public Long handle(AddSportFieldCommand command) {

       return sportFieldService.createSportField(
                command.fieldType(),
                command.fieldSpace(),
                command.city(),
                command.street(),
                command.number());
    }
}
