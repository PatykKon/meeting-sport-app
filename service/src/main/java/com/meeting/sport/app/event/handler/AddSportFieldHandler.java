package com.meeting.sport.app.event.handler;

import com.meeting.sport.app.event.command.AddSportFieldCommand;
import com.meeting.sport.app.event.CommandHandler;
import com.meeting.sport.app.sport_field.SportField;
import com.meeting.sport.app.sport_field.SportFieldRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component

class AddSportFieldHandler implements CommandHandler<AddSportFieldCommand> {

    private final SportFieldRepository sportFieldRepository;

    @Autowired
    AddSportFieldHandler(SportFieldRepository sportFieldRepository) {
        this.sportFieldRepository = sportFieldRepository;
    }

    @Override
    public void handle(AddSportFieldCommand command) {

        SportField sportField = SportField.addSportField(
                command.fieldType(),
                command.fieldSpace(),
                command.city(),
                command.street(),
                command.number());

        sportFieldRepository.save(sportField);

    }
}