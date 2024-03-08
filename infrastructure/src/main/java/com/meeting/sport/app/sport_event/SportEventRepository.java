package com.meeting.sport.app.sport_event;

import com.meeting.sport.app.dto.SportEventDTO;
import org.springframework.stereotype.Repository;

@Repository
public interface SportEventRepository {
    void save(SportEventDTO sportEvent);

//    SportEventResponse getSportEvent(Long eventId);
//
    SportEventDTO findById(Long eventId);
}
