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
    public Long save(EventRole eventRole) {
        EventRoleEntity entity = eventRoleRepositoryJPA.save(EventRoleMapper.modelToEntity(eventRole));
        return entity.getId();
    }

    @Override
    public EventRole getEventRoleByUserAndEvent(Long userId,Long eventId) {
        EventRoleEntity eventRole = eventRoleRepositoryJPA.getEventRoleEntityByUserIdAndSportEventEntityId(userId,eventId);
        return EventRoleMapper.entityToModel(eventRole);
    }

    @Override
    public List<EventRole> getEventRoleEntitiesByUserEntityId(Long userId) {
        List<EventRoleEntity> eventRoleEntities = eventRoleRepositoryJPA.getEventRoleEntitiesByUserId(userId);
        return eventRoleEntities.stream().map(EventRoleMapper::entityToModel).toList();
    }
}
