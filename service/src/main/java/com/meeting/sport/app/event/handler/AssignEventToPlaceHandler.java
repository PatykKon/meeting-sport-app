package com.meeting.sport.app.event.handler;

import com.meeting.sport.app.event.command.AssignEventToPlaceCommand;
import com.meeting.sport.app.event.CommandHandler;
import com.meeting.sport.app.sport_event.SportEvent;
import com.meeting.sport.app.dto.SportEventDTO;
import com.meeting.sport.app.sport_event.SportEventMapper;
import com.meeting.sport.app.sport_event.SportEventRepository;
import com.meeting.sport.app.sport_field.SportField;
import com.meeting.sport.app.dto.SportFieldDTO;
import com.meeting.sport.app.sport_field.SportFieldMapper;
import com.meeting.sport.app.sport_field.SportFieldRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
class AssignEventToPlaceHandler implements CommandHandler<AssignEventToPlaceCommand> {

    private final SportEventRepository sportEventRepository;
    private final SportFieldRepository sportFieldRepository;

    private final SportFieldMapper sportFieldMapper;
    private final SportEventMapper sportEventMapper;

    @Autowired
    AssignEventToPlaceHandler(SportEventRepository sportEventRepository, SportFieldRepository sportFieldRepository, SportFieldMapper sportFieldMapper, SportEventMapper sportEventMapper) {
        this.sportEventRepository = sportEventRepository;
        this.sportFieldRepository = sportFieldRepository;
        this.sportFieldMapper = sportFieldMapper;
        this.sportEventMapper = sportEventMapper;
    }

    @Override
    public void handle(AssignEventToPlaceCommand command) {
        SportEventDTO sportEventDTO = sportEventRepository.findById(command.sportEventId());
        SportFieldDTO sportFieldDTO = sportFieldRepository.findById(command.sportFieldId());

        SportField sportField = sportFieldMapper.DTOToModel(sportFieldDTO);
        SportEvent sportEvent = sportEventMapper.DTOToModel(sportEventDTO);

        sportEvent.submitSportField(sportField);
        sportEventRepository.save(sportEventMapper.modelToDTO(sportEvent));
    }
}
