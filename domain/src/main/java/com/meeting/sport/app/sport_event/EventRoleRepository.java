package com.meeting.sport.app.sport_event;


import java.util.List;

interface EventRoleRepository {

    Long save(EventRole eventRole);

    EventRole getEventRoleByUserAndEvent(Long eventId, Long userId);

    List<EventRole> getEventRoleEntitiesByUserEntityId(Long userId);

}
