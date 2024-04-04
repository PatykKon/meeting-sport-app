package com.meeting.sport.app.event.sport_field;

import com.meeting.sport.app.sport_field.SportField;
import com.meeting.sport.app.sport_field.SportFieldRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
class SportFieldServiceImpl implements SportFieldService {

    private final SportFieldRepository sportFieldRepository;

    @Override
    public Long save(SportField sportField) {
        return sportFieldRepository.save(sportField);
    }
}
