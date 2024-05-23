package com.meeting.sport.app.sport_field;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
interface SportFieldRepository {

    SportField findById(Long sportFieldId);

    SportFieldEntity findById(long sportFieldId);

    List<SportFieldEntity> findAllEntity();

    Long save(SportField sportField);

    boolean isExist(Long id);
}
