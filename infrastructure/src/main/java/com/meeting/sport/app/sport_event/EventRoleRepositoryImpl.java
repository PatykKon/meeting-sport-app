package com.meeting.sport.app.sport_event;

import com.meeting.sport.app.dto.EventRoleResponse;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.NoSuchElementException;

@Repository
class EventRoleRepositoryImpl implements EventRoleRepository {

    private final EventRoleRepositoryJPA eventRoleRepositoryJPA;
    private final EventRoleMapper eventRoleMapper;

    public EventRoleRepositoryImpl(EventRoleRepositoryJPA eventRoleRepositoryJPA, EventRoleMapper eventRoleMapper) {
        this.eventRoleRepositoryJPA = eventRoleRepositoryJPA;
        this.eventRoleMapper = eventRoleMapper;
    }

    @Override
    public EventRole findAvailableRole(long eventId, GameRole gameRole) {
        EventRoleEntity entity = eventRoleRepositoryJPA.findBySportEventEntityIdAndGameRoleAndIsAvailableTrue(eventId, gameRole)
                .stream()
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("Brak dostępnego użytkownika gry dla roli: " + gameRole));

        return eventRoleMapper.entityToModel(entity);
    }

    @Override
    public Long save(EventRole eventRole) {
        EventRoleEntity entity = eventRoleRepositoryJPA.save(eventRoleMapper.modelToEntity(eventRole));
        return entity.getId();
    }

    @Override
    public List<EventRoleResponse> getEventRoleByUser(long userId) {
        List<EventRoleEntity> eventRole = eventRoleRepositoryJPA.getEventRoleEntitiesByUserId(userId);
        return eventRole.stream().map(eventRoleMapper::entityToResponse).toList();
    }
    @Override
    public EventRole getEventRoleByUserAndEvent(Long userId,Long eventId) {
        EventRoleEntity eventRole = eventRoleRepositoryJPA.getEventRoleEntityByUserIdAndSportEventEntityId(userId,eventId);
        return eventRoleMapper.entityToModel(eventRole);
    }

    @Override
    public List<EventRole> getEventRoleEntitiesByUserEntityId(Long userId) {
        List<EventRoleEntity> eventRoleEntities = eventRoleRepositoryJPA.getEventRoleEntitiesByUserId(userId);
        return eventRoleEntities.stream().map(eventRoleMapper::entityToModel).toList();
    }
}
