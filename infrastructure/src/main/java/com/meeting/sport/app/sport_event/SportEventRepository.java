package com.meeting.sport.app.sport_event;

import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SportEventRepository {
    void save(SportEvent sportEvent);

    Optional<SportEventEntity> getSportEvent(Long eventId);
}
