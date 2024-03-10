package com.meeting.sport.app.sport_event;

import com.meeting.sport.app.dto.SportEventDTO;
import com.meeting.sport.app.dto.SportEventResponse;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SportEventRepository {
    void save(SportEventDTO sportEvent);

//    SportEventResponse getSportEvent(Long eventId);
//
    SportEventDTO findById(Long eventId);

    List<SportEventDTO> getAll();
}
