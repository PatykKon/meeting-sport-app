package com.meeting.sport.app.sport_event;

import com.meeting.sport.app.sport_event.dto.EventRoleData;
import com.meeting.sport.app.sport_field.SportField;
import com.meeting.sport.app.user.User;

import java.time.LocalDateTime;
import java.util.List;

interface SportEventService {

    Long laveEvent(Long eventId, Long loggedUserId);

    Long joinEvent(Long eventId,String gameRole,User loggedUser);

    Long createSportEvent(String title,
                          String description,
                          int players,
                          int minAge,
                          LocalDateTime startTime,
                          int gameTime,
                          Long ownerId,
                          int minPlayers);

    Long createGameRoles(Long eventId, List<EventRoleData> eventRoleDataList);

    Long assignFieldToSportEvent(Long sportEventId, SportField sportField);

    void updateStatus();

    void deleteSportEvent(Long sportEventId,Long ownerId);


}
