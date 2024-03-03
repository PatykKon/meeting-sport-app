package com.meeting.sport.app.sport_field;

import org.springframework.stereotype.Repository;

@Repository
public interface SportFieldRepository {

    SportField findById(Long sportFieldId);

    void save(SportField sportField);
}
