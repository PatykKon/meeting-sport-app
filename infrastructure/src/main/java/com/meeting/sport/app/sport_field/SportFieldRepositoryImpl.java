package com.meeting.sport.app.sport_field;

import org.springframework.beans.factory.annotation.Autowired;
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
        return sportFieldMapper.entityToModel(sportField);
    }

    @Override
    public Long save(SportField sportField) {

        SportFieldEntity entity = sportFieldRepositoryJPA.save(sportFieldMapper.modelToEntity(sportField));
        return entity.getId();
    }
}
