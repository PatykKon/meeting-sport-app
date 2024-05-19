package com.meeting.sport.app.sport_field;

import com.meeting.sport.app.sport_field.dto.SportFieldDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
class SportFieldServiceImpl implements SportFieldService {

    private final SportFieldRepository sportFieldRepository;

    @Override
    public SportFieldDTO getSportFieldById(Long sportFieldId) {
        SportField sportField = sportFieldRepository.findById(sportFieldId);
        return SportFieldMapper.modelToDTO(sportField);
    }

    @Override
    public Long createSportField(String fieldType,
                                 String fieldSpace,
                                 String city,
                                 String street,
                                 String number)
    {

        SportField sportField = SportField.createSportField(
                fieldType,
                fieldSpace,
                city,
                street,
                number);

        return sportFieldRepository.save(sportField);
    }
}
