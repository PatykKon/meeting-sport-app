package com.meeting.sport.app.sport_event;

import com.meeting.sport.app.dto.EventRoleResponse;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventRoleRepository {

    EventRole findAvailableRole(long eventId, GameRole gameRole);

    Long save(EventRole eventRole);

    List<EventRoleResponse> getEventRoleByUser(long userId);

    EventRole getEventRoleByUserAndEvent(Long eventId, Long userId);

    List<EventRole> getEventRoleEntitiesByUserEntityId(Long userId);
}
