package com.meeting.sport.app.sport_event;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SportEventRepository {

    Long save(SportEvent sportEvent);

    SportEvent findById(Long eventId);

    List<SportEventEntity> getAll();
}
