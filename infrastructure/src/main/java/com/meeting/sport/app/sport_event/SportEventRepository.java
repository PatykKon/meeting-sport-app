package com.meeting.sport.app.sport_event;

import org.springframework.stereotype.Repository;


public interface SportEventRepository {
    void save(SportEvent sportEvent);

//    SportEventResponse getSportEvent(Long eventId);
//
    SportEvent findById(Long eventId);
}
