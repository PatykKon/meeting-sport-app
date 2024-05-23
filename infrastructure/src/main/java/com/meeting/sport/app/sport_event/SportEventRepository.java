package com.meeting.sport.app.sport_event;

import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
interface SportEventRepository  {

    Long save(SportEvent sportEvent);

    SportEvent findModelById(Long eventId);

    SportEventEntity findEntityById(Long eventId);


    List<SportEvent> findAllSportEvent();

    void saveAll(List<SportEvent> sportEvents);


    List<SportEvent> findAllSportEventByTime(LocalDateTime time);

    void delete(SportEvent sportEvent);

}


