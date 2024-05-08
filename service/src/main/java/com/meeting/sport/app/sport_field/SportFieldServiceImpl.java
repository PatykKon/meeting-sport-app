package com.meeting.sport.app.sport_field;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
class SportFieldServiceImpl implements SportFieldService {

    private final SportFieldRepository sportFieldRepository;


    @Override
    public SportField getSportFieldById(Long sportFieldId) {
        return sportFieldRepository.findById(sportFieldId);
    }

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
