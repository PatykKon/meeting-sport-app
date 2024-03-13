package com.meeting.sport.app.sport_event;

import com.meeting.sport.app.dto.SportEventDTO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SportEventRepository {
    void save(SportEventDTO sportEvent);

    SportEventDTO findById(Long eventId);

    List<SportEventEntity> getAll();
}
