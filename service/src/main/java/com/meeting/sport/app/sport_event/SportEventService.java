package com.meeting.sport.app.sport_event;

import com.meeting.sport.app.sport_event.dto.EventRoleData;
import com.meeting.sport.app.user.dto.UserDTO;

import java.time.LocalDateTime;
import java.util.List;

interface SportEventService {

    Long laveEvent(Long eventId, Long loggedUserId);

    Long joinEvent(Long eventId, String gameRole, UserDTO loggedUser);

    Long createSportEvent(String title,
                          String description,
                          int players,
                          int minAge,
                          LocalDateTime startTime,
                          int gameTime,
                          Long ownerId,
                          int minPlayers);

    Long updateEvent(Long sportEventId,
                     String title,
                     String description,
                     Integer players,
                     Integer minAge,
                     LocalDateTime startTime,
                     Integer gameTime,
                     Long ownerId,
                     Integer minPlayers);

    Long createGameRoles(Long eventId, List<EventRoleData> eventRoleDataList);

    Long assignFieldToSportEvent(Long sportEventId, Long sportFieldId);

    void updateStatus();

    void deleteSportEvent(Long sportEventId, Long ownerId);
}
