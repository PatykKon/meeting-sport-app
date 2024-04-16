package com.meeting.sport.app.sport_event;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.NoSuchElementException;

@Repository
class EventRoleRepositoryImpl implements EventRoleRepository {

    private final EventRoleRepositoryJPA eventRoleRepositoryJPA;


    public EventRoleRepositoryImpl(EventRoleRepositoryJPA eventRoleRepositoryJPA) {
        this.eventRoleRepositoryJPA = eventRoleRepositoryJPA;
    }

    @Override
    public Long save(EventRole eventRole) {
        EventRoleEntity entity = eventRoleRepositoryJPA.save(EventRoleMapper1.modelToEntity(eventRole));
        return entity.getId();
    }

    @Override
    public EventRole getEventRoleByUserAndEvent(Long userId,Long eventId) {
        EventRoleEntity eventRole = eventRoleRepositoryJPA.getEventRoleEntityByUserIdAndSportEventEntityId(userId,eventId);
        return EventRoleMapper1.entityToModel(eventRole);
    }

    @Override
    public List<EventRole> getEventRoleEntitiesByUserEntityId(Long userId) {
        List<EventRoleEntity> eventRoleEntities = eventRoleRepositoryJPA.getEventRoleEntitiesByUserId(userId);
        return eventRoleEntities.stream().map(EventRoleMapper1::entityToModel).toList();
    }
}
