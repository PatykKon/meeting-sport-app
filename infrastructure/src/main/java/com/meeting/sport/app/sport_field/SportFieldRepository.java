package com.meeting.sport.app.sport_field;

import com.meeting.sport.app.dto.SportFieldDTO;
import org.springframework.stereotype.Repository;

@Repository
public interface SportFieldRepository {

    SportFieldDTO findById(Long sportFieldId);

    void save(SportFieldDTO sportField);
}
