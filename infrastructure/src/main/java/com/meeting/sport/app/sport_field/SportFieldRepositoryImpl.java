package com.meeting.sport.app.sport_field;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
class SportFieldRepositoryImpl implements SportFieldRepository {

    private final SportFieldRepositoryJPA sportFieldRepositoryJPA;

    @Autowired
    SportFieldRepositoryImpl(SportFieldRepositoryJPA sportFieldRepositoryJPA) {
        this.sportFieldRepositoryJPA = sportFieldRepositoryJPA;
    }

    @Override
    public SportField findById(Long sportFieldId) {
        SportFieldEntity entity = sportFieldRepositoryJPA.findById(sportFieldId).orElseThrow();
        return SportFieldMapper1.entityToModel(entity);
    }
    public SportFieldEntity findEntityById(long sportFieldId){
        return sportFieldRepositoryJPA.findById(sportFieldId).orElseThrow();
    }

    @Override
    public List<SportFieldEntity> findAllEntity() {
        return sportFieldRepositoryJPA.findAll();
    }

    @Override
    public Long save(SportField sportField) {

        SportFieldEntity entity = sportFieldRepositoryJPA.save(SportFieldMapper1.modelToEntity(sportField));
        return entity.getId();
    }
}
