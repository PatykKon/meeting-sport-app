package com.meeting.sport.app.sport_event;

import java.util.List;

interface EventRoleRepository {

    List<EventRole> getEventRoleEntitiesByUserEntityId(Long userId);

}
