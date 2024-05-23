package com.meeting.sport.app.sport_field;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
class SportFieldServiceImpl implements SportFieldService {

    private final SportFieldRepository sportFieldRepository;

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

    @Override
    public boolean isExist(Long id) {
        return sportFieldRepository.isExist(id);
    }
}
