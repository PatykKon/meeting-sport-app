package com.meeting.sport.app.sport_field;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository

class SportFieldRepositoryImpl implements SportFieldRepository {

    private final SportFieldRepositoryJPA sportFieldRepositoryJPA;
    private final SportFieldMapper sportFieldMapper;

    @Autowired
    SportFieldRepositoryImpl(SportFieldRepositoryJPA sportFieldRepositoryJPA, SportFieldMapper sportFieldMapper) {
        this.sportFieldRepositoryJPA = sportFieldRepositoryJPA;
        this.sportFieldMapper = sportFieldMapper;
    }


    @Override
    public SportField findById(Long sportFieldId) {
       SportFieldEntity sportField = sportFieldRepositoryJPA.findById(sportFieldId).orElseThrow();
       return sportFieldMapper.toModel(sportField);
    }

    @Override
    public void save(SportField sportField) {
        sportFieldRepositoryJPA.save(sportFieldMapper.toEntity(sportField));
    }
}
