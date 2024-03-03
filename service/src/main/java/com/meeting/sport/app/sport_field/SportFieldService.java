package com.meeting.sport.app.sport_field;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
class SportFieldService {

    private final SportFieldRepository sportFieldRepository;

    void addSportField(SportFieldRequest sportFieldRequest) {
        SportField sportField = SportField.addSportField(
                sportFieldRequest.fieldType(),
                sportFieldRequest.fieldSpace(),
                sportFieldRequest.city(),
                sportFieldRequest.street(),
                sportFieldRequest.number());

        sportFieldRepository.save(sportField);
    }
}
