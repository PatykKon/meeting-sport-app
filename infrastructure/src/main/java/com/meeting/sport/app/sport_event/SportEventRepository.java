package com.meeting.sport.app.sport_event;

import org.springframework.stereotype.Repository;

@Repository
public interface SportEventRepository {
    void save(SportEvent sportEvent);
}
