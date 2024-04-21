package com.meeting.sport.app.sport_event;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
interface SportEventRepository  {

    Long save(SportEvent sportEvent);

    SportEvent findModelById(Long eventId);

    SportEventEntity findEntityById(Long eventId);

    List<SportEventEntity> findAllEntity();

    List<SportEvent> findAllSportEvent();

    void saveAll(List<SportEvent> sportEvents);

    List<SportEvent> findAllSportEventByStatus(SportEventStatus sportEventStatus);

    void delete(SportEvent sportEvent);

}


