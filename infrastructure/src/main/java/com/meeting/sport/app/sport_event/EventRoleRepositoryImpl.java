package com.meeting.sport.app.sport_event;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
class EventRoleRepositoryImpl implements EventRoleRepository {

    private final EventRoleRepositoryJPA eventRoleRepositoryJPA;


    public EventRoleRepositoryImpl(EventRoleRepositoryJPA eventRoleRepositoryJPA) {
        this.eventRoleRepositoryJPA = eventRoleRepositoryJPA;
    }

    @Override
    public List<EventRole> getEventRoleEntitiesByUserEntityId(Long userId) {
        List<EventRoleEntity> eventRoleEntities = eventRoleRepositoryJPA.getEventRoleEntitiesByUserId(userId);
        return eventRoleEntities.stream().map(EventRoleMapper::entityToModel).toList();
    }
}
