package com.meeting.sport.app.sport_event;

import com.meeting.sport.app.dto.EventRoleDTO;
import com.meeting.sport.app.dto.EventRoleResponse;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventRoleRepository {

    EventRoleDTO findAvailableRole(long eventId, GameRole gameRole);

    void save(EventRole eventRole);

    boolean isUserExistInEvent(long eventId, long userId);

    List<EventRoleResponse> getEventRoleByUser(long userId);

    EventRoleDTO getEventRoleByUserAndEvent(Long eventId, Long userId);
}
