package com.meeting.sport.app.event.handler;

import com.meeting.sport.app.event.command.AddSportFieldCommand;
import com.meeting.sport.app.event.CommandHandler;
import com.meeting.sport.app.sport_field.SportField;
import com.meeting.sport.app.sport_field.SportFieldMapper;
import com.meeting.sport.app.sport_field.SportFieldRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component

class AddSportFieldHandler implements CommandHandler<AddSportFieldCommand> {

    private final SportFieldRepository sportFieldRepository;
    private final SportFieldMapper sportFieldMapper;

    @Autowired
    AddSportFieldHandler(SportFieldRepository sportFieldRepository, SportFieldMapper sportFieldMapper) {
        this.sportFieldRepository = sportFieldRepository;
        this.sportFieldMapper = sportFieldMapper;
    }

    @Override
    public void handle(AddSportFieldCommand command) {

        SportField sportField = SportField.addSportField(
                command.fieldType(),
                command.fieldSpace(),
                command.city(),
                command.street(),
                command.number());

        sportFieldRepository.save(sportFieldMapper.modelToDTO(sportField));
    }
}
