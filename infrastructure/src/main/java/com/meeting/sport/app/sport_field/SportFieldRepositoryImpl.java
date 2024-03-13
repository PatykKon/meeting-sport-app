package com.meeting.sport.app.sport_field;

import com.meeting.sport.app.dto.SportFieldDTO;
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
public SportFieldDTO findById(Long sportFieldId) {
    SportFieldEntity sportField = sportFieldRepositoryJPA.findById(sportFieldId).orElseThrow();
    return sportFieldMapper.entityToDTO(sportField);
}

    @Override
    public void save(SportFieldDTO sportField) {
        sportFieldRepositoryJPA.save(sportFieldMapper.DTOToEntity(sportField));
    }
}
