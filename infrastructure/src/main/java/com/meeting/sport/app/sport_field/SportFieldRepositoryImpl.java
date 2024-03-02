package com.meeting.sport.app.sport_field;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
class SportFieldRepositoryImpl implements SportFieldRepository {

    private final SportFieldRepositoryJPA sportFieldRepositoryJPA;

    @Override
    public SportField findById(Long sportFieldId) {
        return sportFieldRepositoryJPA.findById(sportFieldId).map(SportFieldMapper::toModel).orElseThrow();
    }
}
