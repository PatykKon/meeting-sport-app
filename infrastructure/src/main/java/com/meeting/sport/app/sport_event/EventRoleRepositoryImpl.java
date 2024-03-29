package com.meeting.sport.app.sport_event;

import com.meeting.sport.app.dto.EventRoleDTO;
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
    public EventRoleDTO findAvailableRole(long eventId, GameRole gameRole) {
        EventRoleEntity entity = eventRoleRepositoryJPA.findBySportEventEntityIdAndGameRoleAndIsAvailableTrue(eventId, gameRole)
                .stream()
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("Brak dostępnego użytkownika gry dla roli: " + gameRole));

        return eventRoleMapper.entityToDTO(entity);
    }

    @Override
    public void save(EventRole eventRole) {
        eventRoleRepositoryJPA.save(eventRoleMapper.modelToEntity(eventRole));
    }

    @Override
    public boolean isUserExistInEvent(long eventId, long userId) {
        return eventRoleRepositoryJPA.isUserExistInEvent(eventId, userId);
    }

    @Override
    public List<EventRoleResponse> getEventRoleByUser(long userId) {
        List<EventRoleEntity> eventRole = eventRoleRepositoryJPA.getEventRoleEntitiesByUserEntity_Id(userId);
        return eventRole.stream().map(eventRoleMapper::entityToResponse).toList();
    }

    @Override
    public EventRoleDTO getEventRoleByUserAndEvent(Long userId,Long eventId) {
        EventRoleEntity eventRole = eventRoleRepositoryJPA.getEventRoleEntityByUserEntityIdAndSportEventEntityId(userId,eventId);
        return eventRoleMapper.entityToDTO(eventRole);
    }
}
