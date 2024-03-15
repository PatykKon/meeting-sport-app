package com.meeting.sport.app.event.sport_field;

import com.meeting.sport.app.sport_field.SportField;
import com.meeting.sport.app.sport_field.SportFieldMapper;
import com.meeting.sport.app.sport_field.SportFieldRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
class SportFieldServiceImpl implements SportFieldService {

    private final SportFieldRepository sportFieldRepository;
    private final SportFieldMapper sportFieldMapper;

    @Override
    public SportField getSportFieldById(Long sportFieldId) {
        return sportFieldMapper.DTOToModel(sportFieldRepository.findById(sportFieldId));
    }

    @Override
    public void save(SportField sportField) {
        sportFieldRepository.save(sportField);
    }
}
